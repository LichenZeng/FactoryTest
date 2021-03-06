package com.mlt.factorytest.item;

import com.mlt.factorytest.R;
//import com.mediatek.common.featureoption.FeatureOption;

import com.mlt.factorytest.ItemTestActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
//import android.telephony.Rlog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @ClassName: HolzerSwitch
 * @Description: This class is used to test the hall switch,By judging the
 *               background color to judge hall switch is normal
 * @Function: Test the hall switch
 * @author: huangguoxiong
 * @date: 2015-1-30 pm3:16:02 Copyright (c) 2015, Malata All Rights Reserved.
 */
public class HallSwitch extends AbsHardware {
    // HolzerSwitch Activity UI
    private View mView;
    // The Interface Prompt information
    private TextView mtvHolzer;
    // Access to the context
    private Context mContext;
    // Layout of the interface
    private RelativeLayout mrlHolzer;
    // Show tips and test results
    private TextView mtvHolzerForTip;
    // Send broadcast to tell the system under test
    private static final String HALLTEST = "com.mlt.action.hall_test";
    // Set broadcast extra value
    private static final String HALLTESTSTATE = "hall_test_state";
    private static final String MALATAHALLSTATE = "malata_hall_state";

    public HallSwitch(String text, Boolean visible) {
        super(text, visible);
    }

    /**
     * Accept the system of the broadcast,if true Set the background for the
     * green and Set the button to clickable
     */
    private BroadcastReceiver mHallBroadcastReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            if ("com.kaka.timer.action.HALL_STATE_CHANGED".equals(intent
                    .getAction())) {
                mtvHolzerForTip.setText(R.string.holzer_test1);
                mtvHolzerForTip.setBackgroundColor(Color.GREEN);
                ItemTestActivity.itemActivity.handler
                        .sendEmptyMessage(ItemTestActivity.MSG_BTN_PASS_CLICKABLE);
                if (intent.getBooleanExtra(MALATAHALLSTATE, true)) {
                    mrlHolzer.setBackgroundColor(Color.GREEN);
                } else {
                    mrlHolzer.setBackgroundColor(mContext.getResources()
                            .getColor(R.color.floralwhite));
                }
            }
        }
    };

    @Override
    public View getView(Context context) {
        mContext = context;
        mView = LayoutInflater.from(context).inflate(
                R.layout.item_holzerswitch, null);
        mtvHolzer = (TextView) mView.findViewById(R.id.tv_holzer);
        mrlHolzer = (RelativeLayout) mView.findViewById(R.id.rl_holzer);
        mtvHolzerForTip = (TextView) mView.findViewById(R.id.tv_hol_testing);
        // Registration broadcast
        // if (FeatureOption.FEATURE_HALL) {
        // IntentFilter filter = new IntentFilter();
        // filter.addAction("com.kaka.timer.action.HALL_STATE_CHANGED");
        // context.registerReceiver(mHallBroadcastReceiver, filter);
        // }
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.kaka.timer.action.HALL_STATE_CHANGED");
        context.registerReceiver(mHallBroadcastReceiver, filter);
        ItemTestActivity.itemActivity.handler
                .sendEmptyMessage(ItemTestActivity.MSG_BTN_PASS_UNCLICKABLE);

        /** set the acitivty title */
        ItemTestActivity.itemActivity.setTitle(R.string.item_hall_switch);
        return mView;
    }

    /**
     * Sent broadcast to the system Shielding notification bar
     */
    @Override
    public void onResume() {
        super.onResume();
        Intent intent = new Intent(HALLTEST);
        intent.putExtra(HALLTESTSTATE, 1);
        mContext.sendBroadcast(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mContext.unregisterReceiver(mHallBroadcastReceiver);
        // if (FeatureOption.FEATURE_HALL) {
        // mContext.unregisterReceiver(mHallBroadcastReceiver);
        // }s
    }

    /**
     * Sent broadcast to the system cancel Shielding notification bar
     */
    @Override
    public void onPause() {
        super.onPause();
        Intent intent = new Intent(HALLTEST);
        intent.putExtra(HALLTESTSTATE, 0);
        mContext.sendBroadcast(intent);
    }
}

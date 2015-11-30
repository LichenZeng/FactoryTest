
#ifndef FACTORY_COMMON_H

#define FACTORY_COMMON_H

#include <stdio.h>
#include <stdbool.h>
#include "cust.h"

//#ifndef bool
//#define bool    int
//#define false   0
//#define true    1
//#endif

#undef LOG_TAG
#define LOG_TAG "FTM"

enum {
    ITEM_MAIN_CAMERA,
    ITEM_MAIN2_CAMERA,
    ITEM_SUB_CAMERA,
    ITEM_STROBE,
    ITEM_GPS,
    ITEM_NFC,
    ITEM_FM,
    ITEM_FMTX,
    ITEM_FLASH,
    ITEM_MEMCARD,
    ITEM_RTC,
    ITEM_LCD,
	ITEM_LCM,
    ITEM_LED,
    ITEM_LOOPBACK,
    ITEM_LOOPBACK1,
    ITEM_LOOPBACK2,
    ITEM_LOOPBACK3,
    ITEM_BT,
    ITEM_WIFI,
    ITEM_KEYS,
    ITEM_LOOPBACK_PHONEMICSPK,
    ITEM_WAVEPLAYBACK,
    ITEM_ACOUSTICLOOPBACK,
    ITEM_GSENSOR,
    ITEM_GS_CALI,
    ITEM_MSENSOR,
    ITEM_ALSPS,
    ITEM_HEADSET,
    ITEM_HEADSET_DEBUG,
    ITEM_USB,
    ITEM_OTG,
    ITEM_CLRFLASH,
    ITEM_CHARGER,
    ITEM_TOUCH,
    ITEM_TOUCH_AUTO,
    ITEM_SIM,
    ITEM_VIBRATOR,
    ITEM_RECEIVER,
    ITEM_RECEIVER_DEBUG,
    ITEM_SIMCARD,
    ITEM_IDLE,
    ITEM_TVOUT,
    ITEM_JOGBALL,
    ITEM_OFN,
    ITEM_MATV_NORMAL,
    ITEM_MATV_AUTOSCAN,
    ITEM_MUI_TEST,
    ITEM_FULL_TEST,
    ITEM_ITEM_TEST,
    ITEM_AUTO_TEST,
    ITEM_DEBUG_TEST,
    ITEM_VERSION,
    ITEM_REPORT,
    ITEM_UPDATE,
    ITEM_REBOOT,
    ITEM_BAROMETER,
    ITEM_GYROSCOPE,
    ITEM_GYROSCOPE_CALI,
    ITEM_SPK_OC,
    ITEM_SIGNALTEST,
    ITEM_CMMB,
    ITEM_EMMC,
    ITEM_EMI,
    ITEM_CLREMMC,
    ITEM_HDMI,
    ITEM_RF_TEST,
    ITEM_RECEIVER_PHONE,
    ITEM_HEADSET_PHONE,
    ITEM_LOOPBACK_PHONEMICSPK_PHONE,
    ITEM_VIBRATOR_PHONE,
    ITEM_MICBIAS,
    ITEM_HOTKNOT,
    ITEM_SHUTDOWN,
    ITEM_VERSION_TEST,
    ITEM_MAX_IDS
};

#endif


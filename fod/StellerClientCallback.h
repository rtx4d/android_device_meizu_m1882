/*
 * Copyright (C) 2020 The MoKee Open Source Project
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 */

#ifndef VENDOR_AOSPA_BIOMETRICS_FINGERPRINT_INSCREEN_V1_0_FINGERPRINTINSCREEN_STELLERCLIENTCALLBACK_H
#define VENDOR_AOSPA_BIOMETRICS_FINGERPRINT_INSCREEN_V1_0_FINGERPRINTINSCREEN_STELLERCLIENTCALLBACK_H

#include <vendor/synaptics/fingerprint/interfaces/extensions/1.0/IStellerClientCallback.h>

namespace vendor {
namespace aospa {
namespace biometrics {
namespace fingerprint {
namespace inscreen {
namespace V1_0 {
namespace implementation {

using ::android::hardware::Return;
using ::android::hardware::Void;

using ::vendor::synaptics::fingerprint::interfaces::extensions::V1_0::IStellerClientCallback;

class StellerClientCallback : public IStellerClientCallback {
  public:
    StellerClientCallback();

    Return<void> atuStatus(int32_t ret) override;
    Return<void> hbmCtrl(int32_t ret) override;
};

}  // namespace implementation
}  // namespace V1_0
}  // namespace inscreen
}  // namespace fingerprint
}  // namespace biometrics
}  // namespace aospa
}  // namespace vendor

#endif  // VENDOR_PA_BIOMETRICS_FINGERPRINT_INSCREEN_V1_0_FINGERPRINTINSCREEN_STELLERCLIENTCALLBACK_H

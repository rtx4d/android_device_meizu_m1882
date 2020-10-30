/*
 * Copyright (C) 2020 The MoKee Open Source Project
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 */

#ifndef VENDOR_PA_TOUCH_V1_0_FIFOWATCHER_H
#define VENDOR_PA_TOUCH_V1_0_FIFOWATCHER_H

#include <functional>
#include <string>
#include <pthread.h>

namespace vendor {
namespace pa {
namespace touch {
namespace V1_0 {
namespace implementation {

using WatcherCallback = std::function<void(const std::string&, int)>;

class FifoWatcher {
  public:
    FifoWatcher(const std::string& file, const WatcherCallback& callback);

    std::string mFile;
    WatcherCallback mCallback;

    volatile bool mExit;

    void exit();

  private:
    pthread_t mPoll;
};

}  // namespace implementation
}  // namespace V1_0
}  // namespace touch
}  // namespace pa
}  // namespace vendor

#endif  // VENDOR_PA_TOUCH_V1_0_FIFOWATCHER_H

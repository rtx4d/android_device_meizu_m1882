# Audio
PRODUCT_PROPERTY_OVERRIDES += \
    af.fast_track_multiplier=1 \
    audio.deep_buffer.media=true \
    audio.offload.disable=true \
    audio.offload.video=true \
    persist.vendor.audio.fluence.speaker=true \
    persist.vendor.audio.fluence.voicecall=true \
    persist.vendor.audio.fluence.voicerec=false \
    persist.vendor.audio.ras.enabled=false \
    persist.vendor.bt.a2dp_offload_cap=sbc-aptx-aptxtws-aptxhd-aac \
    persist.vendor.bt.splita2dp.44_1_war=true \
    ro.af.client_heap_size_kbyte=7168 \
    ro.vendor.audio.sdk.fluencetype=fluence \
    ro.vendor.audio.sdk.ssr=false \
    vendor.audio.adm.buffering.ms=2 \
    vendor.audio.dolby.ds2.enabled=false \
    vendor.audio.dolby.ds2.hardbypass=false \
    vendor.audio.enable.dp.for.voice=false \
    vendor.audio.flac.sw.decoder.24bit=true \
    vendor.audio.hal.output.suspend.supported=true \
    vendor.audio.hw.aac.encoder=true \
    vendor.audio.noisy.broadcast.delay=600 \
    vendor.audio.offload.buffer.size.kb=32 \
    vendor.audio.offload.gapless.enabled=true \
    vendor.audio.offload.multiaac.enable=true \
    vendor.audio.offload.multiple.enabled=false \
    vendor.audio.offload.passthrough=false \
    vendor.audio.offload.pstimeout.secs=10 \
    vendor.audio.offload.track.enable=false \
    vendor.audio.parser.ip.buffer.size=262144 \
    vendor.audio.safx.pbe.enabled=true \
    vendor.audio.tunnel.encode=false \
    vendor.audio.use.sw.alac.decoder=true \
    vendor.audio.use.sw.ape.decoder=true \
    vendor.audio_hal.in_period_size=144 \
    vendor.audio_hal.period_multiplier=3 \
    vendor.audio_hal.period_size=480 \
    vendor.fm.a2dp.conc.disabled=true \
    vendor.voice.path.for.pcm.voip=true \

# Bluetooth
PRODUCT_PROPERTY_OVERRIDES += \
    vendor.bluetooth.soc=cherokee \
    vendor.qcom.bluetooth.soc=cherokee \

# Dalvik
PRODUCT_PROPERTY_OVERRIDES += \
    dalvik.vm.heapgrowthlimit=256m \
    dalvik.vm.heapmaxfree=8m \
    dalvik.vm.heapminfree=512k \
    dalvik.vm.heapsize=512m \
    dalvik.vm.heapstartsize=8m \
    dalvik.vm.heaptargetutilization=0.75 \

# GMS
PRODUCT_GMS_CLIENTID_BASE := android-meizu

# Graphics
PRODUCT_PROPERTY_OVERRIDES += \
    debug.hwui.render_dirty_regions=true \
    persist.vendor.sf.blur.fps=60 \
    persist.vendor.sf.blur.type=progress \

# Meizu
PRODUCT_PROPERTY_OVERRIDES += \
    ro.meizu.autorecorder=true \
    ro.meizu.build.branch=M1892_QOF8_mp1 \
    ro.meizu.build.devowner=meizu \
    ro.meizu.contactmsg.auth=false \
    ro.meizu.customize.pccw=false \
    ro.meizu.dmdebug=false \
    ro.meizu.otaupgrade.config=true \
    ro.meizu.permanentkey=false \
    ro.meizu.published.type=prd \
    ro.meizu.region.enable=true \
    ro.meizu.security=true \
    ro.meizu.setupwizard.flyme=true \
    ro.meizu.setupwizard.setlang=true \
    ro.meizu.sip.support=true \
    ro.meizu.srsenable=true \
    ro.meizu.visualvoicemail=true \
    ro.meizu.voip.support=true \
    ro.meizu_fido_support=1 \
    ro.meizu_ifaa_support=1 \
    ro.meizu_soter_support=1 \

# Misc
PRODUCT_PROPERTY_OVERRIDES += \
    persist.backup.ntpServer=0.pool.ntp.org \
    ro.build.shutdown_timeout=0 \
    ro.vendor.extension_library=libqti-perfd-client.so \
    sys.vendor.shutdown.waittime=500 \

debug.choreographer.skipwarning=3
debug.remote.config.disable=true
drm.service.enabled=true

# OpenGL ES
PRODUCT_PROPERTY_OVERRIDES  += \
    ro.opengles.version=196610 \

# Perf
PRODUCT_PROPERTY_OVERRIDES += \
    debug.migrate.bigcore=true \
    persist.benchmark.mode=1 \
    persist.benchmarkconfig.enable=true \
    persist.perf.level=3 \
    persist.perf.wm_static_blur=true \
    persist.sf.ssr.controlbar=0 \
    persist.sys.at.open=0 \
    persist.sys.disable_blur_view=true \
    persist.sys.enable_scene=true \
    persist.sys.enable_strategy=true \
    persist.sys.keyguard_intercept=true \
    persist.sys.mstore.dl.num=1 \
    persist.sys.prelaunch.off=0 \
    persist.sys.static_blur_mode=false \
    ro.mtk_benchmark_boost_tp=1 \
    ro.product.perf.config=M1892_base \
    ro.sys.fw.bservice_age=5000 \
    ro.sys.fw.bservice_enable=true \
    ro.sys.fw.bservice_limit=5 \
    ro.vendor.qti.cgroup_follow.enable=true \
    ro.vendor.qti.sys.fw.bg_apps_limit=60 \
    ro.vendor.qti.sys.fw.bservice_age=5000 \
    ro.vendor.qti.sys.fw.bservice_enable=true \

# Radio
PRODUCT_PROPERTY_OVERRIDES += \
    persist.call.waiting.volume=60 \
    persist.ct_volte_support=1 \
    persist.dialpad.ecc.volume=60 \
    persist.dialpad.volume=60 \
    persist.radio.fourgOff=1 \
    persist.radio.multisim.config=dsds \
    persist.vendor.radio.apm_sim_not_pwdn=1 \
    persist.vendor.radio.custom_ecc=1 \
    persist.vendor.radio.rat_on=combine \
    persist.vendor.radio.sib16_support=1 \
    rild.libpath=/vendor/lib64/libril-qc-hal-qmi.so \
    ro.cdma.cfall.disable=*730 \
    ro.cdma.cfb.disable=*900 \
    ro.cdma.cfb.enable=*90 \
    ro.cdma.cfdf.disable=*680 \
    ro.cdma.cfdf.enable=*68 \
    ro.cdma.cfnr.disable=*920 \
    ro.cdma.cfnr.enable=*92 \
    ro.cdma.cfu.disable=*720 \
    ro.cdma.cfu.enable=*72 \
    ro.cdma.cw.disable=*740 \
    ro.cdma.cw.enable=*74 \
    ro.com.android.dataroaming=false \

# Thermal
PRODUCT_PROPERTY_OVERRIDES += \
    persist.thermal.config=/vendor/etc/thermal-engine.conf \
    persist.thermalconfig.benchmark=/vendor/etc/thermal.benchmark.conf \
    persist.thermalconfig.high=/vendor/etc/thermal.high.conf \
    persist.thermalconfig.mid=/vendor/etc/thermal.mid.conf \
    persist.thermalconfig.powersave=/vendor/etc/thermal.low.conf \
    persist.thermalengine.platform=qualcomm \
    persist.thermalmanager.enable=true \

# USB HAL
PRODUCT_PROPERTY_OVERRIDES += \
    ro.vendor.usb.use_gadget_hal=true

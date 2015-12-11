.class public interface abstract Lcom/penthera/virtuososdk/monitor/BatteryMonitor$IBatteryObserver;
.super Ljava/lang/Object;
.source "BatteryMonitor.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/monitor/BatteryMonitor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "IBatteryObserver"
.end annotation


# virtual methods
.method public abstract onBatteryLevelChanged(I)V
.end method

.method public abstract onPowerConnected()V
.end method

.method public abstract onPowerDisconnected()V
.end method

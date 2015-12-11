.class public Lcom/amazon/identity/auth/device/DeviceDataInfo;
.super Ljava/lang/Object;
.source "DeviceDataInfo.java"


# instance fields
.field public final isPersistent:Z

.field public final value:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "givenValue"    # Ljava/lang/String;
    .param p2, "persistent"    # Z

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    iput-object p1, p0, Lcom/amazon/identity/auth/device/DeviceDataInfo;->value:Ljava/lang/String;

    .line 12
    iput-boolean p2, p0, Lcom/amazon/identity/auth/device/DeviceDataInfo;->isPersistent:Z

    .line 13
    return-void
.end method

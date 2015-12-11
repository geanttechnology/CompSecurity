.class Lcom/localytics/android/DatapointHelper$AdvertisingInfo;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public id:Ljava/lang/String;

.field public limitAdTracking:Z


# direct methods
.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 238
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 239
    iput-object p1, p0, Lcom/localytics/android/DatapointHelper$AdvertisingInfo;->id:Ljava/lang/String;

    .line 240
    iput-boolean p2, p0, Lcom/localytics/android/DatapointHelper$AdvertisingInfo;->limitAdTracking:Z

    .line 241
    return-void
.end method

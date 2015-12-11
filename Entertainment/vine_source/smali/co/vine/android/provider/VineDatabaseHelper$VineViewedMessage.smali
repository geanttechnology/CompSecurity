.class public Lco/vine/android/provider/VineDatabaseHelper$VineViewedMessage;
.super Ljava/lang/Object;
.source "VineDatabaseHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/provider/VineDatabaseHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "VineViewedMessage"
.end annotation


# instance fields
.field public final conversationId:J

.field public final localStartTime:J

.field public final messageId:J


# direct methods
.method public constructor <init>(JJJ)V
    .locals 0
    .param p1, "conversationId"    # J
    .param p3, "messageId"    # J
    .param p5, "localStartTime"    # J

    .prologue
    .line 3989
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3990
    iput-wide p1, p0, Lco/vine/android/provider/VineDatabaseHelper$VineViewedMessage;->conversationId:J

    .line 3991
    iput-wide p3, p0, Lco/vine/android/provider/VineDatabaseHelper$VineViewedMessage;->messageId:J

    .line 3992
    iput-wide p5, p0, Lco/vine/android/provider/VineDatabaseHelper$VineViewedMessage;->localStartTime:J

    .line 3993
    return-void
.end method

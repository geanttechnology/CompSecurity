.class public final Lcom/dp/utils/SystemTime;
.super Ljava/lang/Object;
.source "SystemTime.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/dp/utils/SystemTime$TimeSource;
    }
.end annotation


# static fields
.field public static final REAL_TIME:Lcom/dp/utils/SystemTime$TimeSource;

.field private static sTimeSource:Lcom/dp/utils/SystemTime$TimeSource;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    new-instance v0, Lcom/dp/utils/SystemTime$1;

    invoke-direct {v0}, Lcom/dp/utils/SystemTime$1;-><init>()V

    sput-object v0, Lcom/dp/utils/SystemTime;->REAL_TIME:Lcom/dp/utils/SystemTime$TimeSource;

    .line 36
    sget-object v0, Lcom/dp/utils/SystemTime;->REAL_TIME:Lcom/dp/utils/SystemTime$TimeSource;

    sput-object v0, Lcom/dp/utils/SystemTime;->sTimeSource:Lcom/dp/utils/SystemTime$TimeSource;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    return-void
.end method

.method public static now()J
    .locals 2

    .prologue
    .line 42
    sget-object v0, Lcom/dp/utils/SystemTime;->sTimeSource:Lcom/dp/utils/SystemTime$TimeSource;

    invoke-interface {v0}, Lcom/dp/utils/SystemTime$TimeSource;->now()J

    move-result-wide v0

    return-wide v0
.end method

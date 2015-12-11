.class public final Lcom/comcast/playerplatform/analytics/java/BuildConfig;
.super Ljava/lang/Object;
.source "BuildConfig.java"


# static fields
.field public static final DEBUG:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 7
    const-string v0, "true"

    invoke-static {v0}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lcom/comcast/playerplatform/analytics/java/BuildConfig;->DEBUG:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

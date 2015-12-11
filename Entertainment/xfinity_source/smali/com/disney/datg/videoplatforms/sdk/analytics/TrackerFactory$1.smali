.class synthetic Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$1;
.super Ljava/lang/Object;
.source "TrackerFactory.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1008
    name = null
.end annotation


# static fields
.field static final synthetic $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackerFactory$TrackerType:[I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 16
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;->values()[Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$1;->$SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackerFactory$TrackerType:[I

    :try_start_0
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$1;->$SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackerFactory$TrackerType:[I

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;->OMNITURE:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_1

    :goto_0
    :try_start_1
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$1;->$SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackerFactory$TrackerType:[I

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;->SLOGGER:Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_0

    :goto_1
    return-void

    :catch_0
    move-exception v0

    goto :goto_1

    :catch_1
    move-exception v0

    goto :goto_0
.end method

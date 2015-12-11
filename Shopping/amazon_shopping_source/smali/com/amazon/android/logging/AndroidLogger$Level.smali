.class final enum Lcom/amazon/android/logging/AndroidLogger$Level;
.super Ljava/lang/Enum;
.source "AndroidLogger.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/android/logging/AndroidLogger;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "Level"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/android/logging/AndroidLogger$Level;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/android/logging/AndroidLogger$Level;

.field private static final HELPER:Lcom/amazon/mas/client/SysPropHelper;

.field private static final TAG:Ljava/lang/String;

.field public static final enum debug:Lcom/amazon/android/logging/AndroidLogger$Level;

.field public static final enum error:Lcom/amazon/android/logging/AndroidLogger$Level;

.field public static final enum informational:Lcom/amazon/android/logging/AndroidLogger$Level;

.field public static final enum none:Lcom/amazon/android/logging/AndroidLogger$Level;

.field public static final enum verbose:Lcom/amazon/android/logging/AndroidLogger$Level;

.field public static final enum warning:Lcom/amazon/android/logging/AndroidLogger$Level;


# instance fields
.field private final level:I


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 35
    new-instance v0, Lcom/amazon/android/logging/AndroidLogger$Level;

    const-string/jumbo v1, "none"

    invoke-direct {v0, v1, v4, v4}, Lcom/amazon/android/logging/AndroidLogger$Level;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/logging/AndroidLogger$Level;->none:Lcom/amazon/android/logging/AndroidLogger$Level;

    .line 38
    new-instance v0, Lcom/amazon/android/logging/AndroidLogger$Level;

    const-string/jumbo v1, "error"

    invoke-direct {v0, v1, v5, v5}, Lcom/amazon/android/logging/AndroidLogger$Level;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/logging/AndroidLogger$Level;->error:Lcom/amazon/android/logging/AndroidLogger$Level;

    .line 41
    new-instance v0, Lcom/amazon/android/logging/AndroidLogger$Level;

    const-string/jumbo v1, "warning"

    invoke-direct {v0, v1, v6, v6}, Lcom/amazon/android/logging/AndroidLogger$Level;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/logging/AndroidLogger$Level;->warning:Lcom/amazon/android/logging/AndroidLogger$Level;

    .line 44
    new-instance v0, Lcom/amazon/android/logging/AndroidLogger$Level;

    const-string/jumbo v1, "informational"

    invoke-direct {v0, v1, v7, v7}, Lcom/amazon/android/logging/AndroidLogger$Level;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/logging/AndroidLogger$Level;->informational:Lcom/amazon/android/logging/AndroidLogger$Level;

    .line 47
    new-instance v0, Lcom/amazon/android/logging/AndroidLogger$Level;

    const-string/jumbo v1, "debug"

    invoke-direct {v0, v1, v8, v8}, Lcom/amazon/android/logging/AndroidLogger$Level;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/logging/AndroidLogger$Level;->debug:Lcom/amazon/android/logging/AndroidLogger$Level;

    .line 50
    new-instance v0, Lcom/amazon/android/logging/AndroidLogger$Level;

    const-string/jumbo v1, "verbose"

    const/4 v2, 0x5

    const/4 v3, 0x5

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/android/logging/AndroidLogger$Level;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/android/logging/AndroidLogger$Level;->verbose:Lcom/amazon/android/logging/AndroidLogger$Level;

    .line 33
    const/4 v0, 0x6

    new-array v0, v0, [Lcom/amazon/android/logging/AndroidLogger$Level;

    sget-object v1, Lcom/amazon/android/logging/AndroidLogger$Level;->none:Lcom/amazon/android/logging/AndroidLogger$Level;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/android/logging/AndroidLogger$Level;->error:Lcom/amazon/android/logging/AndroidLogger$Level;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/android/logging/AndroidLogger$Level;->warning:Lcom/amazon/android/logging/AndroidLogger$Level;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/android/logging/AndroidLogger$Level;->informational:Lcom/amazon/android/logging/AndroidLogger$Level;

    aput-object v1, v0, v7

    sget-object v1, Lcom/amazon/android/logging/AndroidLogger$Level;->debug:Lcom/amazon/android/logging/AndroidLogger$Level;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/android/logging/AndroidLogger$Level;->verbose:Lcom/amazon/android/logging/AndroidLogger$Level;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/android/logging/AndroidLogger$Level;->$VALUES:[Lcom/amazon/android/logging/AndroidLogger$Level;

    .line 54
    const-class v0, Lcom/amazon/android/logging/AndroidLogger$Level;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/logging/AndroidLogger$Level;->TAG:Ljava/lang/String;

    .line 57
    const-string/jumbo v0, "mas.log_level"

    invoke-static {v0}, Lcom/amazon/mas/client/SysPropHelper;->get(Ljava/lang/String;)Lcom/amazon/mas/client/SysPropHelper;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/logging/AndroidLogger$Level;->HELPER:Lcom/amazon/mas/client/SysPropHelper;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .param p3, "thisLevel"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 67
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 68
    iput p3, p0, Lcom/amazon/android/logging/AndroidLogger$Level;->level:I

    .line 69
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/android/logging/AndroidLogger$Level;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 33
    const-class v0, Lcom/amazon/android/logging/AndroidLogger$Level;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/android/logging/AndroidLogger$Level;

    return-object v0
.end method

.method public static values()[Lcom/amazon/android/logging/AndroidLogger$Level;
    .locals 1

    .prologue
    .line 33
    sget-object v0, Lcom/amazon/android/logging/AndroidLogger$Level;->$VALUES:[Lcom/amazon/android/logging/AndroidLogger$Level;

    invoke-virtual {v0}, [Lcom/amazon/android/logging/AndroidLogger$Level;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/android/logging/AndroidLogger$Level;

    return-object v0
.end method


# virtual methods
.method public isEnabled()Z
    .locals 6

    .prologue
    const/4 v3, 0x0

    .line 77
    :try_start_0
    sget-object v4, Lcom/amazon/android/logging/AndroidLogger$Level;->HELPER:Lcom/amazon/mas/client/SysPropHelper;

    # getter for: Lcom/amazon/android/logging/AndroidLogger;->defaultLevel:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/android/logging/AndroidLogger;->access$000()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/amazon/mas/client/SysPropHelper;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 78
    .local v2, "strConfigLevel":Ljava/lang/String;
    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    .line 79
    .local v0, "configLevel":I
    iget v4, p0, Lcom/amazon/android/logging/AndroidLogger$Level;->level:I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    if-gt v4, v0, :cond_0

    const/4 v3, 0x1

    .line 83
    .end local v0    # "configLevel":I
    .end local v2    # "strConfigLevel":Ljava/lang/String;
    :cond_0
    :goto_0
    return v3

    .line 80
    :catch_0
    move-exception v1

    .line 81
    .local v1, "ex":Ljava/lang/NumberFormatException;
    sget-object v4, Lcom/amazon/android/logging/AndroidLogger$Level;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Error attempting to determine system configured log level "

    invoke-static {v4, v5, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

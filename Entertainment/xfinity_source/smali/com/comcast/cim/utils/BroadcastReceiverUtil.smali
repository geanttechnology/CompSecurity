.class public Lcom/comcast/cim/utils/BroadcastReceiverUtil;
.super Ljava/lang/Object;
.source "BroadcastReceiverUtil.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 9
    const-class v0, Lcom/comcast/cim/utils/BroadcastReceiverUtil;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/utils/BroadcastReceiverUtil;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static varargs unregisterBroadcastReceiversQuietly(Landroid/content/ContextWrapper;[Landroid/content/BroadcastReceiver;)V
    .locals 6
    .param p0, "contextWrapper"    # Landroid/content/ContextWrapper;
    .param p1, "receivers"    # [Landroid/content/BroadcastReceiver;

    .prologue
    .line 24
    array-length v3, p1

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v3, :cond_1

    aget-object v1, p1, v2

    .line 25
    .local v1, "receiver":Landroid/content/BroadcastReceiver;
    if-nez v1, :cond_0

    .line 24
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 29
    :cond_0
    :try_start_0
    invoke-virtual {p0, v1}, Landroid/content/ContextWrapper;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 31
    :catch_0
    move-exception v0

    .line 44
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    sget-object v4, Lcom/comcast/cim/utils/BroadcastReceiverUtil;->LOG:Lorg/slf4j/Logger;

    const-string v5, "Exception thrown while unregistering receiver, either it was not registered or registered with a different context"

    invoke-interface {v4, v5}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;)V

    goto :goto_1

    .line 47
    .end local v0    # "e":Ljava/lang/IllegalArgumentException;
    .end local v1    # "receiver":Landroid/content/BroadcastReceiver;
    :cond_1
    return-void
.end method

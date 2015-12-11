.class public final Lcom/amazon/mobile/mash/constants/WebConstants;
.super Ljava/lang/Object;
.source "WebConstants.java"


# static fields
.field private static volatile sWebViewUrlKey:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 35
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/mobile/mash/constants/WebConstants;->sWebViewUrlKey:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static declared-synchronized getWebViewUrlKey()Ljava/lang/String;
    .locals 2

    .prologue
    .line 40
    const-class v1, Lcom/amazon/mobile/mash/constants/WebConstants;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/mobile/mash/constants/WebConstants;->sWebViewUrlKey:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 43
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mobile/mash/constants/WebConstants;->sWebViewUrlKey:Ljava/lang/String;

    .line 45
    :cond_0
    sget-object v0, Lcom/amazon/mobile/mash/constants/WebConstants;->sWebViewUrlKey:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 40
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.class public final Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;
.super Ljava/lang/Object;
.source "ZeroesIntentUtils.java"


# static fields
.field public static final EXTRA_INVALIDATE_CACHE:Ljava/lang/String;

.field public static final EXTRA_RESULT:Ljava/lang/String;

.field public static final EXTRA_RETRIES:Ljava/lang/String;

.field public static final EXTRA_SUCCESS:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 12
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".success"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->EXTRA_SUCCESS:Ljava/lang/String;

    .line 15
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".result"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->EXTRA_RESULT:Ljava/lang/String;

    .line 18
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".retries"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->EXTRA_RETRIES:Ljava/lang/String;

    .line 21
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/amazon/zeroes/intentservice/ZeroesService;->BASE_PACKAGE_NAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".invalidateCache"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->EXTRA_INVALIDATE_CACHE:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 132
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 133
    return-void
.end method

.method public static createFailureIntent(Ljava/lang/String;Landroid/content/Intent;)Landroid/content/Intent;
    .locals 1
    .param p0, "action"    # Ljava/lang/String;
    .param p1, "source"    # Landroid/content/Intent;

    .prologue
    .line 90
    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->createFailureIntent(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/Object;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method public static createFailureIntent(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/Object;)Landroid/content/Intent;
    .locals 1
    .param p0, "action"    # Ljava/lang/String;
    .param p1, "source"    # Landroid/content/Intent;
    .param p2, "result"    # Ljava/lang/Object;

    .prologue
    .line 106
    const/4 v0, 0x0

    invoke-static {p0, p1, v0, p2}, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->createResponseIntent(Ljava/lang/String;Landroid/content/Intent;ZLjava/lang/Object;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method public static createResponseIntent(Ljava/lang/String;Landroid/content/Intent;ZLjava/lang/Object;)Landroid/content/Intent;
    .locals 3
    .param p0, "action"    # Ljava/lang/String;
    .param p1, "source"    # Landroid/content/Intent;
    .param p2, "success"    # Z
    .param p3, "result"    # Ljava/lang/Object;

    .prologue
    .line 39
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0, p0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 40
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {v0, p1}, Landroid/content/Intent;->putExtras(Landroid/content/Intent;)Landroid/content/Intent;

    .line 41
    sget-object v1, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->EXTRA_SUCCESS:Ljava/lang/String;

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 42
    if-eqz p3, :cond_0

    .line 43
    sget-object v1, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->EXTRA_RESULT:Ljava/lang/String;

    invoke-virtual {p3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 46
    :cond_0
    return-object v0
.end method

.method public static createSuccessIntent(Ljava/lang/String;Landroid/content/Intent;)Landroid/content/Intent;
    .locals 1
    .param p0, "action"    # Ljava/lang/String;
    .param p1, "source"    # Landroid/content/Intent;

    .prologue
    .line 60
    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->createSuccessIntent(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/Object;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method public static createSuccessIntent(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/Object;)Landroid/content/Intent;
    .locals 1
    .param p0, "action"    # Ljava/lang/String;
    .param p1, "source"    # Landroid/content/Intent;
    .param p2, "result"    # Ljava/lang/Object;

    .prologue
    .line 76
    const/4 v0, 0x1

    invoke-static {p0, p1, v0, p2}, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->createResponseIntent(Ljava/lang/String;Landroid/content/Intent;ZLjava/lang/Object;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method public static getRetryCount(Landroid/content/Intent;)I
    .locals 2
    .param p0, "intent"    # Landroid/content/Intent;

    .prologue
    .line 117
    sget-object v0, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->EXTRA_RETRIES:Ljava/lang/String;

    const/4 v1, -0x1

    invoke-virtual {p0, v0, v1}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public static shouldInvalidateCache(Landroid/content/Intent;)Z
    .locals 2
    .param p0, "intent"    # Landroid/content/Intent;

    .prologue
    .line 128
    sget-object v0, Lcom/amazon/zeroes/intentservice/utils/ZeroesIntentUtils;->EXTRA_INVALIDATE_CACHE:Ljava/lang/String;

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

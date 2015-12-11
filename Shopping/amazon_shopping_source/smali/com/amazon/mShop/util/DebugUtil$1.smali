.class final Lcom/amazon/mShop/util/DebugUtil$1;
.super Ljava/lang/Object;
.source "DebugUtil.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/util/DebugUtil;->overrideWeblabAssignment(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$context:Landroid/content/Context;

.field final synthetic val$edit:Landroid/widget/EditText;


# direct methods
.method constructor <init>(Landroid/widget/EditText;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 52
    iput-object p1, p0, Lcom/amazon/mShop/util/DebugUtil$1;->val$edit:Landroid/widget/EditText;

    iput-object p2, p0, Lcom/amazon/mShop/util/DebugUtil$1;->val$context:Landroid/content/Context;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 9
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    const/4 v8, 0x0

    .line 56
    iget-object v4, p0, Lcom/amazon/mShop/util/DebugUtil$1;->val$edit:Landroid/widget/EditText;

    invoke-virtual {v4}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 59
    .local v0, "input":Ljava/lang/String;
    const-string/jumbo v2, "[A-Z_0-9]+:[CT][0-9]*"

    .line 60
    .local v2, "validCookieValuePatternBase":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, "(&"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, ")*"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 61
    .local v3, "validCookieValueRegExp":Ljava/lang/String;
    invoke-static {v3}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/regex/Matcher;->find()Z

    move-result v1

    .line 62
    .local v1, "isVlaid":Z
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    if-nez v1, :cond_0

    .line 63
    iget-object v4, p0, Lcom/amazon/mShop/util/DebugUtil$1;->val$context:Landroid/content/Context;

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->set_web_lab_invalid:I

    const/4 v6, 0x1

    invoke-static {v4, v5, v6}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v4

    invoke-virtual {v4}, Landroid/widget/Toast;->show()V

    .line 74
    :goto_0
    return-void

    .line 69
    :cond_0
    iget-object v4, p0, Lcom/amazon/mShop/util/DebugUtil$1;->val$context:Landroid/content/Context;

    const-string/jumbo v5, "experiment"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "\""

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, "\""

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v4, v8, v5, v6}, Lcom/amazon/mShop/net/CookieBridge;->setCookie(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/String;)V

    .line 71
    iget-object v4, p0, Lcom/amazon/mShop/util/DebugUtil$1;->val$context:Landroid/content/Context;

    const-string/jumbo v5, "session-id"

    const-string/jumbo v6, ""

    invoke-static {v4, v8, v5, v6}, Lcom/amazon/mShop/net/CookieBridge;->setCookie(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/String;)V

    .line 72
    iget-object v4, p0, Lcom/amazon/mShop/util/DebugUtil$1;->val$context:Landroid/content/Context;

    const-string/jumbo v5, "ubid-main"

    const-string/jumbo v6, ""

    invoke-static {v4, v8, v5, v6}, Lcom/amazon/mShop/net/CookieBridge;->setCookie(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/String;)V

    .line 73
    iget-object v4, p0, Lcom/amazon/mShop/util/DebugUtil$1;->val$context:Landroid/content/Context;

    # invokes: Lcom/amazon/mShop/util/DebugUtil;->requestNewWeblabAssignment(Landroid/content/Context;)V
    invoke-static {v4}, Lcom/amazon/mShop/util/DebugUtil;->access$000(Landroid/content/Context;)V

    goto :goto_0
.end method

.class Lcom/amazon/mShop/debug/DebugSettingsView$4;
.super Ljava/lang/Object;
.source "DebugSettingsView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/debug/DebugSettingsView;->showNotificationBlock(Landroid/widget/LinearLayout;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/debug/DebugSettingsView;

.field final synthetic val$tokenText:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/debug/DebugSettingsView;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 140
    iput-object p1, p0, Lcom/amazon/mShop/debug/DebugSettingsView$4;->this$0:Lcom/amazon/mShop/debug/DebugSettingsView;

    iput-object p2, p0, Lcom/amazon/mShop/debug/DebugSettingsView$4;->val$tokenText:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 143
    iget-object v2, p0, Lcom/amazon/mShop/debug/DebugSettingsView$4;->val$tokenText:Ljava/lang/String;

    invoke-static {v2}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 144
    .local v0, "encodedTokenText":Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "mailto:yourmail@amazon.com?body="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "&subject=NotificationToken"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 145
    .local v1, "mailUrl":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/debug/DebugSettingsView$4;->this$0:Lcom/amazon/mShop/debug/DebugSettingsView;

    invoke-virtual {v2}, Lcom/amazon/mShop/debug/DebugSettingsView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2, v1}, Lcom/amazon/mShop/util/WebUtils;->handleMailtoLink(Landroid/content/Context;Ljava/lang/String;)Z

    .line 146
    return-void
.end method

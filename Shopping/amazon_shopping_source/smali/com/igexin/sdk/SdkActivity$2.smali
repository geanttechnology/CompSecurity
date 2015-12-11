.class Lcom/igexin/sdk/SdkActivity$2;
.super Ljava/lang/Object;
.source "SdkActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/igexin/sdk/SdkActivity;->showDialog()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/igexin/sdk/SdkActivity;

.field final synthetic val$button:Lcom/igexin/sdk/bean/ButtonBean;


# direct methods
.method constructor <init>(Lcom/igexin/sdk/SdkActivity;Lcom/igexin/sdk/bean/ButtonBean;)V
    .locals 0

    .prologue
    .line 180
    iput-object p1, p0, Lcom/igexin/sdk/SdkActivity$2;->this$0:Lcom/igexin/sdk/SdkActivity;

    iput-object p2, p0, Lcom/igexin/sdk/SdkActivity$2;->val$button:Lcom/igexin/sdk/bean/ButtonBean;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 183
    invoke-static {}, Lcom/igexin/sdk/action/PushMessageAction;->getInstance()Lcom/igexin/sdk/action/PushMessageAction;

    move-result-object v0

    iget-object v1, p0, Lcom/igexin/sdk/SdkActivity$2;->this$0:Lcom/igexin/sdk/SdkActivity;

    # getter for: Lcom/igexin/sdk/SdkActivity;->pushMessageBean:Lcom/igexin/sdk/bean/PushMessageBean;
    invoke-static {v1}, Lcom/igexin/sdk/SdkActivity;->access$000(Lcom/igexin/sdk/SdkActivity;)Lcom/igexin/sdk/bean/PushMessageBean;

    move-result-object v1

    iget-object v2, p0, Lcom/igexin/sdk/SdkActivity$2;->val$button:Lcom/igexin/sdk/bean/ButtonBean;

    invoke-virtual {v2}, Lcom/igexin/sdk/bean/ButtonBean;->getDoActionId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/igexin/sdk/action/PushMessageAction;->executePushMessageAction(Lcom/igexin/sdk/bean/PushMessageBean;Ljava/lang/String;)Z

    .line 184
    iget-object v0, p0, Lcom/igexin/sdk/SdkActivity$2;->this$0:Lcom/igexin/sdk/SdkActivity;

    const/4 v1, 0x0

    # setter for: Lcom/igexin/sdk/SdkActivity;->flag:Z
    invoke-static {v0, v1}, Lcom/igexin/sdk/SdkActivity;->access$102(Lcom/igexin/sdk/SdkActivity;Z)Z

    .line 185
    iget-object v0, p0, Lcom/igexin/sdk/SdkActivity$2;->this$0:Lcom/igexin/sdk/SdkActivity;

    invoke-virtual {v0}, Lcom/igexin/sdk/SdkActivity;->finish()V

    .line 186
    return-void
.end method

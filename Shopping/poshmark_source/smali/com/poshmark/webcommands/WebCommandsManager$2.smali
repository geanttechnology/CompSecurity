.class Lcom/poshmark/webcommands/WebCommandsManager$2;
.super Ljava/lang/Object;
.source "WebCommandsManager.java"

# interfaces
.implements Lcom/poshmark/utils/UIThreadTask$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/webcommands/WebCommandsManager;->alertForWebView(Lcom/poshmark/webcommands/WebCommand;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/webcommands/WebCommandsManager;

.field final synthetic val$command:Lcom/poshmark/webcommands/WebCommand;


# direct methods
.method constructor <init>(Lcom/poshmark/webcommands/WebCommandsManager;Lcom/poshmark/webcommands/WebCommand;)V
    .locals 0

    .prologue
    .line 293
    iput-object p1, p0, Lcom/poshmark/webcommands/WebCommandsManager$2;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iput-object p2, p0, Lcom/poshmark/webcommands/WebCommandsManager$2;->val$command:Lcom/poshmark/webcommands/WebCommand;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public runOnUIThread(Ljava/lang/Object;)V
    .locals 10
    .param p1, "data"    # Ljava/lang/Object;

    .prologue
    .line 296
    iget-object v8, p0, Lcom/poshmark/webcommands/WebCommandsManager$2;->val$command:Lcom/poshmark/webcommands/WebCommand;

    iget-object v8, v8, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v9, "title"

    invoke-interface {v8, v9}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-static {v8}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 297
    .local v7, "title":Ljava/lang/String;
    iget-object v8, p0, Lcom/poshmark/webcommands/WebCommandsManager$2;->val$command:Lcom/poshmark/webcommands/WebCommand;

    iget-object v8, v8, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v9, "message"

    invoke-interface {v8, v9}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-static {v8}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 298
    .local v4, "message":Ljava/lang/String;
    iget-object v8, p0, Lcom/poshmark/webcommands/WebCommandsManager$2;->val$command:Lcom/poshmark/webcommands/WebCommand;

    iget-object v8, v8, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v9, "cancelButtonTitle"

    invoke-interface {v8, v9}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 299
    .local v2, "cancelButtonTitle":Ljava/lang/String;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v8

    if-nez v8, :cond_1

    .line 300
    :cond_0
    iget-object v8, p0, Lcom/poshmark/webcommands/WebCommandsManager$2;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v8, v8, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    const v9, 0x7f0601e1

    invoke-virtual {v8, v9}, Lcom/poshmark/ui/PMActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 302
    :cond_1
    iget-object v8, p0, Lcom/poshmark/webcommands/WebCommandsManager$2;->val$command:Lcom/poshmark/webcommands/WebCommand;

    iget-object v8, v8, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v9, "okButtonTitle"

    invoke-interface {v8, v9}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 304
    .local v5, "okButtonTitle":Ljava/lang/String;
    iget-object v8, p0, Lcom/poshmark/webcommands/WebCommandsManager$2;->val$command:Lcom/poshmark/webcommands/WebCommand;

    iget-object v8, v8, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v9, "alertOkCallbackMethodName"

    invoke-interface {v8, v9}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 305
    .local v6, "okCallback":Ljava/lang/String;
    iget-object v8, p0, Lcom/poshmark/webcommands/WebCommandsManager$2;->val$command:Lcom/poshmark/webcommands/WebCommand;

    iget-object v8, v8, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v9, "alertCancelCallbackMethodName"

    invoke-interface {v8, v9}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 307
    .local v3, "cancelCallback":Ljava/lang/String;
    new-instance v1, Landroid/app/AlertDialog$Builder;

    iget-object v8, p0, Lcom/poshmark/webcommands/WebCommandsManager$2;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v8, v8, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    invoke-direct {v1, v8}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 309
    .local v1, "alertDialogBuilder":Landroid/app/AlertDialog$Builder;
    invoke-virtual {v1, v7}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 311
    invoke-virtual {v1, v4}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 312
    const/4 v8, 0x0

    invoke-virtual {v1, v8}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    .line 313
    if-eqz v5, :cond_2

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v8

    if-lez v8, :cond_2

    .line 314
    new-instance v8, Lcom/poshmark/webcommands/WebCommandsManager$2$1;

    invoke-direct {v8, p0, v6}, Lcom/poshmark/webcommands/WebCommandsManager$2$1;-><init>(Lcom/poshmark/webcommands/WebCommandsManager$2;Ljava/lang/String;)V

    invoke-virtual {v1, v5, v8}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 321
    :cond_2
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v8

    if-lez v8, :cond_3

    .line 322
    new-instance v8, Lcom/poshmark/webcommands/WebCommandsManager$2$2;

    invoke-direct {v8, p0, v3}, Lcom/poshmark/webcommands/WebCommandsManager$2$2;-><init>(Lcom/poshmark/webcommands/WebCommandsManager$2;Ljava/lang/String;)V

    invoke-virtual {v1, v2, v8}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 329
    :cond_3
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 331
    .local v0, "alertDialog":Landroid/app/AlertDialog;
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 332
    return-void
.end method

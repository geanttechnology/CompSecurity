.class Lcom/poshmark/utils/PMSetIPDialog$1;
.super Ljava/lang/Object;
.source "PMSetIPDialog.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/PMSetIPDialog;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/PMSetIPDialog;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/PMSetIPDialog;)V
    .locals 0

    .prologue
    .line 42
    iput-object p1, p0, Lcom/poshmark/utils/PMSetIPDialog$1;->this$0:Lcom/poshmark/utils/PMSetIPDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 11
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 46
    iget-object v9, p0, Lcom/poshmark/utils/PMSetIPDialog$1;->this$0:Lcom/poshmark/utils/PMSetIPDialog;

    iget-object v9, v9, Lcom/poshmark/utils/PMSetIPDialog;->dialoglayout:Landroid/view/View;

    const v10, 0x7f0c02a0

    invoke-virtual {v9, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    .line 47
    .local v1, "octet1":Landroid/widget/EditText;
    iget-object v9, p0, Lcom/poshmark/utils/PMSetIPDialog$1;->this$0:Lcom/poshmark/utils/PMSetIPDialog;

    iget-object v9, v9, Lcom/poshmark/utils/PMSetIPDialog;->dialoglayout:Landroid/view/View;

    const v10, 0x7f0c02a1

    invoke-virtual {v9, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/EditText;

    .line 48
    .local v2, "octet2":Landroid/widget/EditText;
    iget-object v9, p0, Lcom/poshmark/utils/PMSetIPDialog$1;->this$0:Lcom/poshmark/utils/PMSetIPDialog;

    iget-object v9, v9, Lcom/poshmark/utils/PMSetIPDialog;->dialoglayout:Landroid/view/View;

    const v10, 0x7f0c02a2

    invoke-virtual {v9, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/EditText;

    .line 49
    .local v3, "octet3":Landroid/widget/EditText;
    iget-object v9, p0, Lcom/poshmark/utils/PMSetIPDialog$1;->this$0:Lcom/poshmark/utils/PMSetIPDialog;

    iget-object v9, v9, Lcom/poshmark/utils/PMSetIPDialog;->dialoglayout:Landroid/view/View;

    const v10, 0x7f0c02a3

    invoke-virtual {v9, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    .line 51
    .local v4, "octet4":Landroid/widget/EditText;
    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    .line 52
    .local v5, "str1":Ljava/lang/String;
    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    .line 53
    .local v6, "str2":Ljava/lang/String;
    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    .line 54
    .local v7, "str3":Ljava/lang/String;
    invoke-virtual {v4}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    .line 56
    .local v8, "str4":Ljava/lang/String;
    if-eqz v5, :cond_0

    if-eqz v6, :cond_0

    if-eqz v7, :cond_0

    .line 57
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "http://"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "."

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "."

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "."

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, ":9292"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 58
    .local v0, "ip":Ljava/lang/String;
    invoke-static {v0}, Lcom/poshmark/config/EnvConfig;->setupDevIP(Ljava/lang/String;)V

    .line 59
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v9

    invoke-virtual {v9, v0}, Lcom/poshmark/application/PMApplicationSession;->setDevIP(Ljava/lang/String;)V

    .line 60
    iget-object v9, p0, Lcom/poshmark/utils/PMSetIPDialog$1;->this$0:Lcom/poshmark/utils/PMSetIPDialog;

    invoke-virtual {v9}, Lcom/poshmark/utils/PMSetIPDialog;->dismiss()V

    .line 63
    .end local v0    # "ip":Ljava/lang/String;
    :cond_0
    return-void
.end method

.class Lcom/livemixtapes/LoginActivity$1;
.super Ljava/lang/Object;
.source "LoginActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/LoginActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/LoginActivity;


# direct methods
.method constructor <init>(Lcom/livemixtapes/LoginActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/LoginActivity$1;->this$0:Lcom/livemixtapes/LoginActivity;

    .line 64
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 66
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/livemixtapes/LoginActivity$1;->this$0:Lcom/livemixtapes/LoginActivity;

    .line 67
    const-class v2, Lcom/livemixtapes/MainActivity;

    .line 66
    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 68
    .local v0, "myIntent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/livemixtapes/LoginActivity$1;->this$0:Lcom/livemixtapes/LoginActivity;

    invoke-virtual {v1, v0}, Lcom/livemixtapes/LoginActivity;->startActivity(Landroid/content/Intent;)V

    .line 69
    return-void
.end method

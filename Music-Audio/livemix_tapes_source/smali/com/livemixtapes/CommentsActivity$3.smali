.class Lcom/livemixtapes/CommentsActivity$3;
.super Ljava/lang/Object;
.source "CommentsActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/CommentsActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/CommentsActivity;


# direct methods
.method constructor <init>(Lcom/livemixtapes/CommentsActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/CommentsActivity$3;->this$0:Lcom/livemixtapes/CommentsActivity;

    .line 121
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 124
    iget-object v1, p0, Lcom/livemixtapes/CommentsActivity$3;->this$0:Lcom/livemixtapes/CommentsActivity;

    iget-object v1, v1, Lcom/livemixtapes/CommentsActivity;->commentsEditText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-interface {v1}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v0

    .line 125
    .local v0, "commentStr":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_0

    .line 143
    :goto_0
    return-void

    .line 127
    :cond_0
    invoke-static {}, Lcom/livemixtapes/User;->getAuth()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_1

    .line 128
    new-instance v1, Landroid/app/AlertDialog$Builder;

    iget-object v2, p0, Lcom/livemixtapes/CommentsActivity$3;->this$0:Lcom/livemixtapes/CommentsActivity;

    invoke-direct {v1, v2}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 129
    const-string v2, "Login"

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    .line 130
    const-string v2, "Please login to post a comment"

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    .line 131
    const-string v2, "OK"

    .line 132
    new-instance v3, Lcom/livemixtapes/CommentsActivity$3$1;

    invoke-direct {v3, p0}, Lcom/livemixtapes/CommentsActivity$3$1;-><init>(Lcom/livemixtapes/CommentsActivity$3;)V

    .line 131
    invoke-virtual {v1, v2, v3}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    .line 140
    const v2, 0x1080027

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    goto :goto_0

    .line 142
    :cond_1
    new-instance v1, Lcom/livemixtapes/CommentsActivity$PostComment;

    iget-object v2, p0, Lcom/livemixtapes/CommentsActivity$3;->this$0:Lcom/livemixtapes/CommentsActivity;

    const/4 v3, 0x0

    invoke-direct {v1, v2, v3}, Lcom/livemixtapes/CommentsActivity$PostComment;-><init>(Lcom/livemixtapes/CommentsActivity;Lcom/livemixtapes/CommentsActivity$PostComment;)V

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    aput-object v0, v2, v3

    invoke-virtual {v1, v2}, Lcom/livemixtapes/CommentsActivity$PostComment;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

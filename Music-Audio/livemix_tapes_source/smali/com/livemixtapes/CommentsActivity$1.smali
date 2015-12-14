.class Lcom/livemixtapes/CommentsActivity$1;
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
    iput-object p1, p0, Lcom/livemixtapes/CommentsActivity$1;->this$0:Lcom/livemixtapes/CommentsActivity;

    .line 91
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 96
    iget-object v0, p0, Lcom/livemixtapes/CommentsActivity$1;->this$0:Lcom/livemixtapes/CommentsActivity;

    invoke-virtual {v0}, Lcom/livemixtapes/CommentsActivity;->onBackPressed()V

    .line 97
    return-void
.end method

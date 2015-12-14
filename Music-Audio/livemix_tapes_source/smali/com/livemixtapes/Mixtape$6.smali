.class Lcom/livemixtapes/Mixtape$6;
.super Ljava/lang/Object;
.source "Mixtape.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Mixtape;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/Mixtape;


# direct methods
.method constructor <init>(Lcom/livemixtapes/Mixtape;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Mixtape$6;->this$0:Lcom/livemixtapes/Mixtape;

    .line 589
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 593
    iget-object v0, p0, Lcom/livemixtapes/Mixtape$6;->this$0:Lcom/livemixtapes/Mixtape;

    invoke-virtual {v0}, Lcom/livemixtapes/Mixtape;->showCommentPopup()V

    .line 595
    return-void
.end method

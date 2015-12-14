.class Lcom/livemixtapes/Mixtapes$6;
.super Ljava/lang/Object;
.source "Mixtapes.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Mixtapes;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/Mixtapes;


# direct methods
.method constructor <init>(Lcom/livemixtapes/Mixtapes;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Mixtapes$6;->this$0:Lcom/livemixtapes/Mixtapes;

    .line 248
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 251
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$6;->this$0:Lcom/livemixtapes/Mixtapes;

    const-string v1, "unreleased"

    # invokes: Lcom/livemixtapes/Mixtapes;->switchMixtapeView(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lcom/livemixtapes/Mixtapes;->access$8(Lcom/livemixtapes/Mixtapes;Ljava/lang/String;)V

    .line 252
    return-void
.end method

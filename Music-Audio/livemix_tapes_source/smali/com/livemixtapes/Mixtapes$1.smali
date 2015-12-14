.class Lcom/livemixtapes/Mixtapes$1;
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
    iput-object p1, p0, Lcom/livemixtapes/Mixtapes$1;->this$0:Lcom/livemixtapes/Mixtapes;

    .line 155
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 158
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$1;->this$0:Lcom/livemixtapes/Mixtapes;

    new-instance v1, Lcom/livemixtapes/Mixtapes$JSONParse;

    iget-object v2, p0, Lcom/livemixtapes/Mixtapes$1;->this$0:Lcom/livemixtapes/Mixtapes;

    const/4 v3, 0x0

    invoke-direct {v1, v2, v3}, Lcom/livemixtapes/Mixtapes$JSONParse;-><init>(Lcom/livemixtapes/Mixtapes;Lcom/livemixtapes/Mixtapes$JSONParse;)V

    iput-object v1, v0, Lcom/livemixtapes/Mixtapes;->JSONTask:Lcom/livemixtapes/Mixtapes$JSONParse;

    .line 160
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$1;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v0, v0, Lcom/livemixtapes/Mixtapes;->JSONTask:Lcom/livemixtapes/Mixtapes$JSONParse;

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/livemixtapes/Mixtapes$JSONParse;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 162
    return-void
.end method

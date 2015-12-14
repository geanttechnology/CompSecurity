.class Lcom/livemixtapes/MixtapeList$2;
.super Ljava/lang/Object;
.source "MixtapeList.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/MixtapeList;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/MixtapeList;


# direct methods
.method constructor <init>(Lcom/livemixtapes/MixtapeList;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/MixtapeList$2;->this$0:Lcom/livemixtapes/MixtapeList;

    .line 67
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/livemixtapes/MixtapeList$2;->this$0:Lcom/livemixtapes/MixtapeList;

    invoke-virtual {v0}, Lcom/livemixtapes/MixtapeList;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->onBackPressed()V

    .line 71
    return-void
.end method

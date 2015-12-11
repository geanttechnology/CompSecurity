.class Lcom/poshmark/ui/fragments/GestureTester$3;
.super Ljava/lang/Object;
.source "GestureTester.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/GestureTester;->onActivityCreated(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/GestureTester;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/GestureTester;)V
    .locals 0

    .prologue
    .line 85
    iput-object p1, p0, Lcom/poshmark/ui/fragments/GestureTester$3;->this$0:Lcom/poshmark/ui/fragments/GestureTester;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 88
    iget-object v0, p0, Lcom/poshmark/ui/fragments/GestureTester$3;->this$0:Lcom/poshmark/ui/fragments/GestureTester;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/GestureTester;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 89
    return-void
.end method

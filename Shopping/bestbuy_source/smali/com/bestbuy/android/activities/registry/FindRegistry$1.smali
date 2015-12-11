.class Lcom/bestbuy/android/activities/registry/FindRegistry$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/registry/FindRegistry;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/FindRegistry;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/FindRegistry;)V
    .locals 0

    .prologue
    .line 60
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/FindRegistry$1;->a:Lcom/bestbuy/android/activities/registry/FindRegistry;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 64
    check-cast p1, Landroid/widget/CheckBox;

    invoke-virtual {p1}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 68
    :cond_0
    return-void
.end method

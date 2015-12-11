.class Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemSelectedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)V
    .locals 0

    .prologue
    .line 169
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$2;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemSelected(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 174
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$2;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->a(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)Landroid/widget/Spinner;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Spinner;->getSelectedItem()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "Select a state"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 175
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$2;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0, v3}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->a(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z

    .line 176
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$2;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->b(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$2;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->c(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$2;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->d(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$2;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->e(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$2;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->f(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$2;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->g(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$2;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->h(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 177
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$2;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0, v3}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->b(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z

    .line 178
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$2;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0, v3}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->c(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z

    .line 188
    :goto_0
    return-void

    .line 180
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$2;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->b(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z

    .line 181
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$2;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->c(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z

    goto :goto_0

    .line 184
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$2;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->a(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z

    .line 185
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$2;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->b(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z

    .line 186
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$2;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->c(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z

    goto :goto_0
.end method

.method public onNothingSelected(Landroid/widget/AdapterView;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 192
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$2;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->a(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;Z)Z

    .line 193
    return-void
.end method

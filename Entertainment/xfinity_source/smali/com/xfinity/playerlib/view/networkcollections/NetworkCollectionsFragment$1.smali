.class Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$1;
.super Ljava/lang/Object;
.source "NetworkCollectionsFragment.java"

# interfaces
.implements Lit/sephiroth/android/library/widget/AdapterView$OnItemSelectedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->createGallery(Landroid/view/ViewGroup;I)I
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field isCallingSetSelection:Z

.field final synthetic this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

.field final synthetic val$gallery:Lit/sephiroth/android/library/widget/HListView;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;Lit/sephiroth/android/library/widget/HListView;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    .prologue
    .line 127
    iput-object p1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$1;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$1;->val$gallery:Lit/sephiroth/android/library/widget/HListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemSelected(Lit/sephiroth/android/library/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 1
    .param p2, "view"    # Landroid/view/View;
    .param p3, "i"    # I
    .param p4, "l"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lit/sephiroth/android/library/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 133
    .local p1, "adapterView":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<*>;"
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$1;->isCallingSetSelection:Z

    if-eqz v0, :cond_0

    .line 136
    :cond_0
    return-void
.end method

.method public onNothingSelected(Lit/sephiroth/android/library/widget/AdapterView;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lit/sephiroth/android/library/widget/AdapterView",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 146
    .local p1, "adapterView":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<*>;"
    return-void
.end method

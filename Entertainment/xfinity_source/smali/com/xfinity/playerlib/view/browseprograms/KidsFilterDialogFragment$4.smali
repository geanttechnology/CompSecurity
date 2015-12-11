.class Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment$4;
.super Ljava/lang/Object;
.source "KidsFilterDialogFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->buildCheckBoxsViews(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;

    .prologue
    .line 177
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 180
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->subscriptionOnlyCheckBox:Landroid/widget/CheckBox;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->access$100(Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;)Landroid/widget/CheckBox;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/CheckBox;->performClick()Z

    .line 181
    return-void
.end method

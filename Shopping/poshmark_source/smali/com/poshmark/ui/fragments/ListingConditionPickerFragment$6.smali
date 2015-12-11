.class Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$6;
.super Ljava/lang/Object;
.source "ListingConditionPickerFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->setupActionBar()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;)V
    .locals 0

    .prologue
    .line 209
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$6;->this$0:Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 212
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment$6;->this$0:Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;

    # invokes: Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->returnData()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;->access$000(Lcom/poshmark/ui/fragments/ListingConditionPickerFragment;)V

    .line 213
    return-void
.end method

.class Lcom/poshmark/ui/fragments/PricePickerFragment$2;
.super Ljava/lang/Object;
.source "PricePickerFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/PricePickerFragment;->setupActionBar()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/PricePickerFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/PricePickerFragment;)V
    .locals 0

    .prologue
    .line 103
    iput-object p1, p0, Lcom/poshmark/ui/fragments/PricePickerFragment$2;->this$0:Lcom/poshmark/ui/fragments/PricePickerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 106
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PricePickerFragment$2;->this$0:Lcom/poshmark/ui/fragments/PricePickerFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PricePickerFragment;->returnData()Z

    .line 107
    return-void
.end method

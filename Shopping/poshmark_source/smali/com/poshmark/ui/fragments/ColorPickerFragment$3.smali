.class Lcom/poshmark/ui/fragments/ColorPickerFragment$3;
.super Ljava/lang/Object;
.source "ColorPickerFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ColorPickerFragment;->setupActionBar()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ColorPickerFragment;)V
    .locals 0

    .prologue
    .line 241
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 244
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ColorPickerFragment$3;->this$0:Lcom/poshmark/ui/fragments/ColorPickerFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/ColorPickerFragment;->returnData()Z

    .line 245
    return-void
.end method

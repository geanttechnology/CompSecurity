.class Lcom/poshmark/ui/fragments/MySizePickerFragment$5;
.super Ljava/lang/Object;
.source "MySizePickerFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/MySizePickerFragment;->setupActionBar()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/MySizePickerFragment;)V
    .locals 0

    .prologue
    .line 240
    iput-object p1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$5;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 243
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment$5;->this$0:Lcom/poshmark/ui/fragments/MySizePickerFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->returnData()Z

    .line 244
    return-void
.end method

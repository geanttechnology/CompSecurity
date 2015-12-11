.class Lcom/poshmark/ui/fragments/ListingFiltersFragment$20;
.super Ljava/lang/Object;
.source "ListingFiltersFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingFiltersFragment;->setupView(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ListingFiltersFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingFiltersFragment;)V
    .locals 0

    .prologue
    .line 791
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment$20;->this$0:Lcom/poshmark/ui/fragments/ListingFiltersFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 794
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingFiltersFragment$20;->this$0:Lcom/poshmark/ui/fragments/ListingFiltersFragment;

    # invokes: Lcom/poshmark/ui/fragments/ListingFiltersFragment;->launchConditionSelection()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/ListingFiltersFragment;->access$200(Lcom/poshmark/ui/fragments/ListingFiltersFragment;)V

    .line 795
    return-void
.end method

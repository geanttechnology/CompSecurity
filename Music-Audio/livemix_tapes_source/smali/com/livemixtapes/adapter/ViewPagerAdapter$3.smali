.class Lcom/livemixtapes/adapter/ViewPagerAdapter$3;
.super Ljava/lang/Object;
.source "ViewPagerAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/adapter/ViewPagerAdapter;->instantiateItem(Landroid/view/ViewGroup;I)Ljava/lang/Object;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/adapter/ViewPagerAdapter;

.field private final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/livemixtapes/adapter/ViewPagerAdapter;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter$3;->this$0:Lcom/livemixtapes/adapter/ViewPagerAdapter;

    iput p2, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter$3;->val$position:I

    .line 88
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 91
    iget-object v0, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter$3;->this$0:Lcom/livemixtapes/adapter/ViewPagerAdapter;

    # getter for: Lcom/livemixtapes/adapter/ViewPagerAdapter;->callbacks:Lcom/livemixtapes/adapter/ViewPagerAdapter$PagerCallbacks;
    invoke-static {v0}, Lcom/livemixtapes/adapter/ViewPagerAdapter;->access$0(Lcom/livemixtapes/adapter/ViewPagerAdapter;)Lcom/livemixtapes/adapter/ViewPagerAdapter$PagerCallbacks;

    move-result-object v0

    iget v1, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter$3;->val$position:I

    const/4 v2, 0x2

    invoke-interface {v0, v1, v2}, Lcom/livemixtapes/adapter/ViewPagerAdapter$PagerCallbacks;->onShowMixtape(II)V

    .line 92
    return-void
.end method

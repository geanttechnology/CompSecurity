.class Lit/sephiroth/android/library/widget/HListView$FocusSelector;
.super Ljava/lang/Object;
.source "HListView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lit/sephiroth/android/library/widget/HListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FocusSelector"
.end annotation


# instance fields
.field private mPosition:I

.field private mPositionLeft:I

.field final synthetic this$0:Lit/sephiroth/android/library/widget/HListView;


# direct methods
.method private constructor <init>(Lit/sephiroth/android/library/widget/HListView;)V
    .locals 0

    .prologue
    .line 1079
    iput-object p1, p0, Lit/sephiroth/android/library/widget/HListView$FocusSelector;->this$0:Lit/sephiroth/android/library/widget/HListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lit/sephiroth/android/library/widget/HListView;Lit/sephiroth/android/library/widget/HListView$1;)V
    .locals 0
    .param p1, "x0"    # Lit/sephiroth/android/library/widget/HListView;
    .param p2, "x1"    # Lit/sephiroth/android/library/widget/HListView$1;

    .prologue
    .line 1079
    invoke-direct {p0, p1}, Lit/sephiroth/android/library/widget/HListView$FocusSelector;-><init>(Lit/sephiroth/android/library/widget/HListView;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 1092
    iget-object v0, p0, Lit/sephiroth/android/library/widget/HListView$FocusSelector;->this$0:Lit/sephiroth/android/library/widget/HListView;

    iget v1, p0, Lit/sephiroth/android/library/widget/HListView$FocusSelector;->mPosition:I

    iget v2, p0, Lit/sephiroth/android/library/widget/HListView$FocusSelector;->mPositionLeft:I

    invoke-virtual {v0, v1, v2}, Lit/sephiroth/android/library/widget/HListView;->setSelectionFromLeft(II)V

    .line 1093
    return-void
.end method

.method public setup(II)Lit/sephiroth/android/library/widget/HListView$FocusSelector;
    .locals 0
    .param p1, "position"    # I
    .param p2, "left"    # I

    .prologue
    .line 1085
    iput p1, p0, Lit/sephiroth/android/library/widget/HListView$FocusSelector;->mPosition:I

    .line 1086
    iput p2, p0, Lit/sephiroth/android/library/widget/HListView$FocusSelector;->mPositionLeft:I

    .line 1087
    return-object p0
.end method

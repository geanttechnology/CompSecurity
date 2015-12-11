.class public Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;
.super Landroid/widget/BaseAdapter;
.source "DragSortWidget.java"

# interfaces
.implements Landroid/widget/ListAdapter;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/dragsort/DragSortWidget;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "DragSortAdapterWrapper"
.end annotation


# instance fields
.field private mAdapter:Landroid/widget/ListAdapter;

.field private mContext:Landroid/content/Context;

.field private mObserver:Landroid/database/DataSetObserver;

.field final synthetic this$0:Lco/vine/android/dragsort/DragSortWidget;


# direct methods
.method public constructor <init>(Lco/vine/android/dragsort/DragSortWidget;Landroid/content/Context;)V
    .locals 1
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 1134
    iput-object p1, p0, Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 1126
    new-instance v0, Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper$1;

    invoke-direct {v0, p0}, Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper$1;-><init>(Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;)V

    iput-object v0, p0, Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;->mObserver:Landroid/database/DataSetObserver;

    .line 1135
    iput-object p2, p0, Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;->mContext:Landroid/content/Context;

    .line 1136
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 1147
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v0}, Landroid/widget/ListAdapter;->getCount()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 1152
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v0, p1}, Landroid/widget/ListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 1157
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v0, p1}, Landroid/widget/ListAdapter;->getItemId(I)J

    move-result-wide v0

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 7
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v5, 0x0

    .line 1169
    if-eqz p2, :cond_0

    move-object v1, p2

    .line 1170
    check-cast v1, Lco/vine/android/dragsort/DragSortWidget$DragSortListItem;

    .line 1171
    .local v1, "item":Lco/vine/android/dragsort/DragSortWidget$DragSortListItem;
    invoke-virtual {v1, p1}, Lco/vine/android/dragsort/DragSortWidget$DragSortListItem;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 1172
    .local v3, "oldChild":Landroid/view/View;
    iget-object v4, p0, Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v4, p1, v3, p3}, Landroid/widget/ListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 1177
    .end local v3    # "oldChild":Landroid/view/View;
    .local v0, "child":Landroid/view/View;
    :goto_0
    invoke-virtual {v1}, Lco/vine/android/dragsort/DragSortWidget$DragSortListItem;->removeAllViews()V

    .line 1178
    invoke-virtual {v1, v0}, Lco/vine/android/dragsort/DragSortWidget$DragSortListItem;->addView(Landroid/view/View;)V

    .line 1179
    iget-object v4, p0, Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    # getter for: Lco/vine/android/dragsort/DragSortWidget;->mSelectionPosition:I
    invoke-static {v4}, Lco/vine/android/dragsort/DragSortWidget;->access$2200(Lco/vine/android/dragsort/DragSortWidget;)I

    move-result v4

    if-ne p1, v4, :cond_1

    const/4 v4, 0x1

    :goto_1
    invoke-virtual {v1, v4}, Lco/vine/android/dragsort/DragSortWidget$DragSortListItem;->setActivated(Z)V

    .line 1180
    iget-object v4, p0, Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    # getter for: Lco/vine/android/dragsort/DragSortWidget;->mFocusedPosition:I
    invoke-static {v4}, Lco/vine/android/dragsort/DragSortWidget;->access$2500(Lco/vine/android/dragsort/DragSortWidget;)I

    move-result v4

    if-ne p1, v4, :cond_2

    const/high16 v4, 0x3f800000    # 1.0f

    :goto_2
    invoke-virtual {v1, v4}, Lco/vine/android/dragsort/DragSortWidget$DragSortListItem;->setAlpha(F)V

    .line 1182
    invoke-virtual {v1}, Lco/vine/android/dragsort/DragSortWidget$DragSortListItem;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    .line 1183
    .local v2, "lp":Landroid/view/ViewGroup$LayoutParams;
    iget-object v4, p0, Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    iget-boolean v4, v4, Lco/vine/android/dragsort/DragSortWidget;->mRemoving:Z

    if-eqz v4, :cond_3

    iget-object v4, p0, Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    # getter for: Lco/vine/android/dragsort/DragSortWidget;->mRemovePosition:I
    invoke-static {v4}, Lco/vine/android/dragsort/DragSortWidget;->access$2100(Lco/vine/android/dragsort/DragSortWidget;)I

    move-result v4

    if-ne p1, v4, :cond_3

    .line 1184
    iget-object v4, p0, Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    # getter for: Lco/vine/android/dragsort/DragSortWidget;->mRemoveAnimator:Lco/vine/android/dragsort/DragSortWidget$RemoveAnimator;
    invoke-static {v4}, Lco/vine/android/dragsort/DragSortWidget;->access$2600(Lco/vine/android/dragsort/DragSortWidget;)Lco/vine/android/dragsort/DragSortWidget$RemoveAnimator;

    move-result-object v4

    # getter for: Lco/vine/android/dragsort/DragSortWidget$RemoveAnimator;->mWidth:I
    invoke-static {v4}, Lco/vine/android/dragsort/DragSortWidget$RemoveAnimator;->access$2700(Lco/vine/android/dragsort/DragSortWidget$RemoveAnimator;)I

    move-result v4

    iput v4, v2, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 1189
    :goto_3
    invoke-virtual {v1, v2}, Lco/vine/android/dragsort/DragSortWidget$DragSortListItem;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 1191
    iget-object v4, p0, Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    # getter for: Lco/vine/android/dragsort/DragSortWidget;->mFloatView:Landroid/widget/ImageView;
    invoke-static {v4}, Lco/vine/android/dragsort/DragSortWidget;->access$2800(Lco/vine/android/dragsort/DragSortWidget;)Landroid/widget/ImageView;

    move-result-object v4

    if-eqz v4, :cond_4

    iget-object v4, p0, Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    # getter for: Lco/vine/android/dragsort/DragSortWidget;->mFloatViewListPosition:I
    invoke-static {v4}, Lco/vine/android/dragsort/DragSortWidget;->access$100(Lco/vine/android/dragsort/DragSortWidget;)I

    move-result v4

    if-ne p1, v4, :cond_4

    .line 1192
    const/4 v4, 0x4

    invoke-virtual {v1, v4}, Lco/vine/android/dragsort/DragSortWidget$DragSortListItem;->setVisibility(I)V

    .line 1197
    :goto_4
    return-object v1

    .line 1174
    .end local v0    # "child":Landroid/view/View;
    .end local v1    # "item":Lco/vine/android/dragsort/DragSortWidget$DragSortListItem;
    .end local v2    # "lp":Landroid/view/ViewGroup$LayoutParams;
    :cond_0
    iget-object v4, p0, Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;->mAdapter:Landroid/widget/ListAdapter;

    const/4 v6, 0x0

    invoke-interface {v4, p1, v6, p3}, Landroid/widget/ListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 1175
    .restart local v0    # "child":Landroid/view/View;
    new-instance v1, Lco/vine/android/dragsort/DragSortWidget$DragSortListItem;

    iget-object v4, p0, Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;->this$0:Lco/vine/android/dragsort/DragSortWidget;

    iget-object v6, p0, Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;->mContext:Landroid/content/Context;

    invoke-direct {v1, v4, v6}, Lco/vine/android/dragsort/DragSortWidget$DragSortListItem;-><init>(Lco/vine/android/dragsort/DragSortWidget;Landroid/content/Context;)V

    .restart local v1    # "item":Lco/vine/android/dragsort/DragSortWidget$DragSortListItem;
    goto :goto_0

    :cond_1
    move v4, v5

    .line 1179
    goto :goto_1

    .line 1180
    :cond_2
    const v4, 0x3e99999a    # 0.3f

    goto :goto_2

    .line 1187
    .restart local v2    # "lp":Landroid/view/ViewGroup$LayoutParams;
    :cond_3
    iput v5, v2, Landroid/view/ViewGroup$LayoutParams;->width:I

    goto :goto_3

    .line 1194
    :cond_4
    invoke-virtual {v1, v5}, Lco/vine/android/dragsort/DragSortWidget$DragSortListItem;->setVisibility(I)V

    goto :goto_4
.end method

.method public isEnabled(I)Z
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 1162
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v0, p1}, Landroid/widget/ListAdapter;->isEnabled(I)Z

    move-result v0

    return v0
.end method

.method public setAdapter(Landroid/widget/ListAdapter;)V
    .locals 1
    .param p1, "adapter"    # Landroid/widget/ListAdapter;

    .prologue
    .line 1139
    iput-object p1, p0, Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;->mAdapter:Landroid/widget/ListAdapter;

    .line 1140
    if-eqz p1, :cond_0

    .line 1141
    iget-object v0, p0, Lco/vine/android/dragsort/DragSortWidget$DragSortAdapterWrapper;->mObserver:Landroid/database/DataSetObserver;

    invoke-interface {p1, v0}, Landroid/widget/ListAdapter;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 1143
    :cond_0
    return-void
.end method

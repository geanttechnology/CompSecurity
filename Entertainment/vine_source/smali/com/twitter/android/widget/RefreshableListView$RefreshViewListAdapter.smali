.class Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;
.super Landroid/widget/HeaderViewListAdapter;
.source "RefreshableListView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/twitter/android/widget/RefreshableListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "RefreshViewListAdapter"
.end annotation


# instance fields
.field private final mDataSetObserver:Lcom/twitter/android/widget/RefreshableListView$AdapterDataSetObserver;

.field private mRegistered:Z

.field final synthetic this$0:Lcom/twitter/android/widget/RefreshableListView;


# direct methods
.method public constructor <init>(Lcom/twitter/android/widget/RefreshableListView;Ljava/util/ArrayList;Ljava/util/ArrayList;Landroid/widget/ListAdapter;Lcom/twitter/android/widget/RefreshableListView$AdapterDataSetObserver;)V
    .locals 0
    .param p4, "adapter"    # Landroid/widget/ListAdapter;
    .param p5, "observer"    # Lcom/twitter/android/widget/RefreshableListView$AdapterDataSetObserver;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/widget/ListView$FixedViewInfo;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/widget/ListView$FixedViewInfo;",
            ">;",
            "Landroid/widget/ListAdapter;",
            "Lcom/twitter/android/widget/RefreshableListView$AdapterDataSetObserver;",
            ")V"
        }
    .end annotation

    .prologue
    .line 1003
    .local p2, "headerViewInfos":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/widget/ListView$FixedViewInfo;>;"
    .local p3, "footerViewInfos":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/widget/ListView$FixedViewInfo;>;"
    iput-object p1, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    .line 1004
    invoke-direct {p0, p2, p3, p4}, Landroid/widget/HeaderViewListAdapter;-><init>(Ljava/util/ArrayList;Ljava/util/ArrayList;Landroid/widget/ListAdapter;)V

    .line 1005
    iput-object p5, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->mDataSetObserver:Lcom/twitter/android/widget/RefreshableListView$AdapterDataSetObserver;

    .line 1006
    invoke-virtual {p0}, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->registerDataSetObserver()V

    .line 1007
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 1091
    iget-object v0, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    iget v0, v0, Lcom/twitter/android/widget/RefreshableListView;->mItemCount:I

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 1095
    iget-object v0, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    const/16 v1, 0x22

    invoke-virtual {v0, v1}, Lcom/twitter/android/widget/RefreshableListView;->isMode(I)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1096
    if-nez p1, :cond_0

    .line 1097
    const/4 v0, 0x0

    .line 1102
    :goto_0
    return-object v0

    .line 1099
    :cond_0
    add-int/lit8 v0, p1, -0x1

    invoke-super {p0, v0}, Landroid/widget/HeaderViewListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0

    .line 1102
    :cond_1
    invoke-super {p0, p1}, Landroid/widget/HeaderViewListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 1107
    iget-object v0, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    const/16 v1, 0x22

    invoke-virtual {v0, v1}, Lcom/twitter/android/widget/RefreshableListView;->isMode(I)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1108
    if-nez p1, :cond_0

    .line 1109
    const-wide/16 v0, 0x0

    .line 1114
    :goto_0
    return-wide v0

    .line 1111
    :cond_0
    add-int/lit8 v0, p1, -0x1

    invoke-super {p0, v0}, Landroid/widget/HeaderViewListAdapter;->getItemId(I)J

    move-result-wide v0

    goto :goto_0

    .line 1114
    :cond_1
    invoke-super {p0, p1}, Landroid/widget/HeaderViewListAdapter;->getItemId(I)J

    move-result-wide v0

    goto :goto_0
.end method

.method public getItemViewType(I)I
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 1137
    iget-object v0, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    const/16 v1, 0x22

    invoke-virtual {v0, v1}, Lcom/twitter/android/widget/RefreshableListView;->isMode(I)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1138
    if-nez p1, :cond_0

    .line 1139
    const/4 v0, -0x1

    .line 1144
    :goto_0
    return v0

    .line 1141
    :cond_0
    add-int/lit8 v0, p1, -0x1

    invoke-super {p0, v0}, Landroid/widget/HeaderViewListAdapter;->getItemViewType(I)I

    move-result v0

    goto :goto_0

    .line 1144
    :cond_1
    invoke-super {p0, p1}, Landroid/widget/HeaderViewListAdapter;->getItemViewType(I)I

    move-result v0

    goto :goto_0
.end method

.method getSuperCount()I
    .locals 1

    .prologue
    .line 1087
    invoke-super {p0}, Landroid/widget/HeaderViewListAdapter;->getCount()I

    move-result v0

    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 3
    .param p1, "position"    # I
    .param p2, "view"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 1119
    iget-object v1, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    const/16 v2, 0x22

    invoke-virtual {v1, v2}, Lcom/twitter/android/widget/RefreshableListView;->isMode(I)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1120
    if-nez p1, :cond_0

    .line 1121
    iget-object v1, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    iget-object v1, v1, Lcom/twitter/android/widget/RefreshableListView;->mRefreshView:Landroid/widget/RelativeLayout;

    .line 1131
    :goto_0
    return-object v1

    .line 1123
    :cond_0
    add-int/lit8 v1, p1, -0x1

    invoke-super {p0, v1, p2, p3}, Landroid/widget/HeaderViewListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    goto :goto_0

    .line 1127
    :cond_1
    :try_start_0
    invoke-super {p0, p1, p2, p3}, Landroid/widget/HeaderViewListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    :try_end_0
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    goto :goto_0

    .line 1128
    :catch_0
    move-exception v0

    .line 1130
    .local v0, "e":Ljava/lang/IndexOutOfBoundsException;
    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 1131
    iget-object v1, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    iget-object v1, v1, Lcom/twitter/android/widget/RefreshableListView;->mRefreshView:Landroid/widget/RelativeLayout;

    goto :goto_0
.end method

.method public isEnabled(I)Z
    .locals 8
    .param p1, "position"    # I

    .prologue
    const/4 v6, 0x0

    .line 1050
    iget-object v5, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    const/16 v7, 0x22

    invoke-virtual {v5, v7}, Lcom/twitter/android/widget/RefreshableListView;->isMode(I)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 1051
    if-lez p1, :cond_0

    add-int/lit8 v5, p1, -0x1

    invoke-virtual {p0, v5}, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->superEnabled(I)Z

    move-result v5

    if-eqz v5, :cond_0

    const/4 v5, 0x1

    .line 1077
    :goto_0
    return v5

    :cond_0
    move v5, v6

    .line 1051
    goto :goto_0

    .line 1054
    :cond_1
    :try_start_0
    invoke-virtual {p0, p1}, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->superEnabled(I)Z
    :try_end_0
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v5

    goto :goto_0

    .line 1055
    :catch_0
    move-exception v2

    .line 1057
    .local v2, "e":Ljava/lang/IndexOutOfBoundsException;
    iget-object v5, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    # getter for: Lcom/twitter/android/widget/RefreshableListView;->mHeaderViewInfos:Ljava/util/ArrayList;
    invoke-static {v5}, Lcom/twitter/android/widget/RefreshableListView;->access$000(Lcom/twitter/android/widget/RefreshableListView;)Ljava/util/ArrayList;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v4

    .line 1058
    .local v4, "numHeaders":I
    if-ge p1, v4, :cond_2

    .line 1059
    iget-object v5, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    # getter for: Lcom/twitter/android/widget/RefreshableListView;->mHeaderViewInfos:Ljava/util/ArrayList;
    invoke-static {v5}, Lcom/twitter/android/widget/RefreshableListView;->access$000(Lcom/twitter/android/widget/RefreshableListView;)Ljava/util/ArrayList;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/widget/ListView$FixedViewInfo;

    iget-boolean v5, v5, Landroid/widget/ListView$FixedViewInfo;->isSelectable:Z

    goto :goto_0

    .line 1063
    :cond_2
    sub-int v1, p1, v4

    .line 1064
    .local v1, "adjPosition":I
    const/4 v0, 0x0

    .line 1065
    .local v0, "adapterCount":I
    iget-object v5, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    # getter for: Lcom/twitter/android/widget/RefreshableListView;->mAdapter:Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;
    invoke-static {v5}, Lcom/twitter/android/widget/RefreshableListView;->access$100(Lcom/twitter/android/widget/RefreshableListView;)Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;

    move-result-object v5

    if-eqz v5, :cond_3

    .line 1066
    iget-object v5, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    # getter for: Lcom/twitter/android/widget/RefreshableListView;->mAdapter:Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;
    invoke-static {v5}, Lcom/twitter/android/widget/RefreshableListView;->access$100(Lcom/twitter/android/widget/RefreshableListView;)Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;

    move-result-object v5

    invoke-virtual {v5}, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->getCount()I

    move-result v0

    .line 1067
    if-ge v1, v0, :cond_3

    .line 1068
    iget-object v5, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    # getter for: Lcom/twitter/android/widget/RefreshableListView;->mAdapter:Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;
    invoke-static {v5}, Lcom/twitter/android/widget/RefreshableListView;->access$100(Lcom/twitter/android/widget/RefreshableListView;)Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;

    move-result-object v5

    invoke-virtual {v5, v1}, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->isEnabled(I)Z

    move-result v5

    goto :goto_0

    .line 1074
    :cond_3
    :try_start_1
    iget-object v5, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    # getter for: Lcom/twitter/android/widget/RefreshableListView;->mFooterViewInfos:Ljava/util/ArrayList;
    invoke-static {v5}, Lcom/twitter/android/widget/RefreshableListView;->access$200(Lcom/twitter/android/widget/RefreshableListView;)Ljava/util/ArrayList;

    move-result-object v5

    sub-int v7, v1, v0

    invoke-virtual {v5, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/widget/ListView$FixedViewInfo;

    iget-boolean v5, v5, Landroid/widget/ListView$FixedViewInfo;->isSelectable:Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    .line 1075
    :catch_1
    move-exception v3

    .line 1076
    .local v3, "e2":Ljava/lang/Exception;
    invoke-static {v3}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    move v5, v6

    .line 1077
    goto :goto_0
.end method

.method public final registerDataSetObserver()V
    .locals 1

    .prologue
    .line 1149
    iget-boolean v0, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->mRegistered:Z

    if-nez v0, :cond_0

    .line 1150
    iget-object v0, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->mDataSetObserver:Lcom/twitter/android/widget/RefreshableListView$AdapterDataSetObserver;

    invoke-super {p0, v0}, Landroid/widget/HeaderViewListAdapter;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 1151
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->mRegistered:Z

    .line 1153
    :cond_0
    return-void
.end method

.method public registerDataSetObserver(Landroid/database/DataSetObserver;)V
    .locals 1
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 1011
    iget-object v0, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->mDataSetObserver:Lcom/twitter/android/widget/RefreshableListView$AdapterDataSetObserver;

    invoke-virtual {v0, p1}, Lcom/twitter/android/widget/RefreshableListView$AdapterDataSetObserver;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 1012
    return-void
.end method

.method public superEnabled(I)Z
    .locals 7
    .param p1, "position"    # I

    .prologue
    .line 1021
    :try_start_0
    invoke-super {p0, p1}, Landroid/widget/HeaderViewListAdapter;->isEnabled(I)Z
    :try_end_0
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v5

    .line 1044
    :goto_0
    return v5

    .line 1022
    :catch_0
    move-exception v2

    .line 1024
    .local v2, "e":Ljava/lang/IndexOutOfBoundsException;
    iget-object v5, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    # getter for: Lcom/twitter/android/widget/RefreshableListView;->mHeaderViewInfos:Ljava/util/ArrayList;
    invoke-static {v5}, Lcom/twitter/android/widget/RefreshableListView;->access$000(Lcom/twitter/android/widget/RefreshableListView;)Ljava/util/ArrayList;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v4

    .line 1025
    .local v4, "numHeaders":I
    if-ge p1, v4, :cond_0

    .line 1026
    iget-object v5, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    # getter for: Lcom/twitter/android/widget/RefreshableListView;->mHeaderViewInfos:Ljava/util/ArrayList;
    invoke-static {v5}, Lcom/twitter/android/widget/RefreshableListView;->access$000(Lcom/twitter/android/widget/RefreshableListView;)Ljava/util/ArrayList;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/widget/ListView$FixedViewInfo;

    iget-boolean v5, v5, Landroid/widget/ListView$FixedViewInfo;->isSelectable:Z

    goto :goto_0

    .line 1030
    :cond_0
    sub-int v1, p1, v4

    .line 1031
    .local v1, "adjPosition":I
    const/4 v0, 0x0

    .line 1032
    .local v0, "adapterCount":I
    iget-object v5, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    # getter for: Lcom/twitter/android/widget/RefreshableListView;->mAdapter:Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;
    invoke-static {v5}, Lcom/twitter/android/widget/RefreshableListView;->access$100(Lcom/twitter/android/widget/RefreshableListView;)Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;

    move-result-object v5

    if-eqz v5, :cond_1

    .line 1033
    iget-object v5, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    # getter for: Lcom/twitter/android/widget/RefreshableListView;->mAdapter:Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;
    invoke-static {v5}, Lcom/twitter/android/widget/RefreshableListView;->access$100(Lcom/twitter/android/widget/RefreshableListView;)Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;

    move-result-object v5

    invoke-virtual {v5}, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->getCount()I

    move-result v0

    .line 1034
    if-ge v1, v0, :cond_1

    .line 1035
    iget-object v5, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    # getter for: Lcom/twitter/android/widget/RefreshableListView;->mAdapter:Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;
    invoke-static {v5}, Lcom/twitter/android/widget/RefreshableListView;->access$100(Lcom/twitter/android/widget/RefreshableListView;)Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;

    move-result-object v5

    invoke-virtual {v5, v1}, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->isEnabled(I)Z

    move-result v5

    goto :goto_0

    .line 1041
    :cond_1
    :try_start_1
    iget-object v5, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->this$0:Lcom/twitter/android/widget/RefreshableListView;

    # getter for: Lcom/twitter/android/widget/RefreshableListView;->mFooterViewInfos:Ljava/util/ArrayList;
    invoke-static {v5}, Lcom/twitter/android/widget/RefreshableListView;->access$200(Lcom/twitter/android/widget/RefreshableListView;)Ljava/util/ArrayList;

    move-result-object v5

    sub-int v6, v1, v0

    invoke-virtual {v5, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/widget/ListView$FixedViewInfo;

    iget-boolean v5, v5, Landroid/widget/ListView$FixedViewInfo;->isSelectable:Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    .line 1042
    :catch_1
    move-exception v3

    .line 1043
    .local v3, "e2":Ljava/lang/Exception;
    invoke-static {v3}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 1044
    const/4 v5, 0x0

    goto :goto_0
.end method

.method public final unregisterDataSetObserver()V
    .locals 1

    .prologue
    .line 1156
    iget-boolean v0, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->mRegistered:Z

    if-eqz v0, :cond_0

    .line 1157
    iget-object v0, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->mDataSetObserver:Lcom/twitter/android/widget/RefreshableListView$AdapterDataSetObserver;

    invoke-super {p0, v0}, Landroid/widget/HeaderViewListAdapter;->unregisterDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 1158
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->mRegistered:Z

    .line 1160
    :cond_0
    return-void
.end method

.method public unregisterDataSetObserver(Landroid/database/DataSetObserver;)V
    .locals 1
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 1016
    iget-object v0, p0, Lcom/twitter/android/widget/RefreshableListView$RefreshViewListAdapter;->mDataSetObserver:Lcom/twitter/android/widget/RefreshableListView$AdapterDataSetObserver;

    invoke-virtual {v0, p1}, Lcom/twitter/android/widget/RefreshableListView$AdapterDataSetObserver;->unregisterDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 1017
    return-void
.end method

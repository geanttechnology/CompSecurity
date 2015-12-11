.class Lco/vine/android/views/HorizontalListView$Recycler;
.super Ljava/lang/Object;
.source "HorizontalListView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/views/HorizontalListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "Recycler"
.end annotation


# instance fields
.field private mActiveViews:[Landroid/view/View;

.field private mFirstActivePos:I

.field private final mRecycleViews:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lco/vine/android/views/HorizontalListView;


# direct methods
.method public constructor <init>(Lco/vine/android/views/HorizontalListView;)V
    .locals 1

    .prologue
    .line 1168
    iput-object p1, p0, Lco/vine/android/views/HorizontalListView$Recycler;->this$0:Lco/vine/android/views/HorizontalListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1165
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/views/HorizontalListView$Recycler;->mRecycleViews:Ljava/util/ArrayList;

    .line 1169
    return-void
.end method

.method private pruneRecycleViews()V
    .locals 8

    .prologue
    .line 1207
    iget-object v5, p0, Lco/vine/android/views/HorizontalListView$Recycler;->mActiveViews:[Landroid/view/View;

    array-length v1, v5

    .line 1208
    .local v1, "maxViews":I
    iget-object v2, p0, Lco/vine/android/views/HorizontalListView$Recycler;->mRecycleViews:Ljava/util/ArrayList;

    .line 1209
    .local v2, "recycledViews":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v3

    .line 1210
    .local v3, "size":I
    sub-int v4, v3, v1

    .line 1211
    .local v4, "sizeDiff":I
    add-int/lit8 v3, v3, -0x1

    .line 1212
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v4, :cond_0

    .line 1213
    iget-object v6, p0, Lco/vine/android/views/HorizontalListView$Recycler;->this$0:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/view/View;

    const/4 v7, 0x0

    # invokes: Lco/vine/android/views/HorizontalListView;->removeDetachedView(Landroid/view/View;Z)V
    invoke-static {v6, v5, v7}, Lco/vine/android/views/HorizontalListView;->access$600(Lco/vine/android/views/HorizontalListView;Landroid/view/View;Z)V

    .line 1214
    add-int/lit8 v3, v3, -0x1

    .line 1212
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1216
    :cond_0
    return-void
.end method


# virtual methods
.method public addRecycleView(Landroid/view/View;I)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;
    .param p2, "position"    # I

    .prologue
    .line 1249
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Lco/vine/android/views/HorizontalListView$LayoutParams;

    .line 1250
    .local v0, "lp":Lco/vine/android/views/HorizontalListView$LayoutParams;
    if-nez v0, :cond_0

    .line 1257
    :goto_0
    return-void

    .line 1254
    :cond_0
    iput p2, v0, Lco/vine/android/views/HorizontalListView$LayoutParams;->recycledPosition:I

    .line 1255
    const/4 v1, 0x1

    iput-boolean v1, v0, Lco/vine/android/views/HorizontalListView$LayoutParams;->recycled:Z

    .line 1256
    iget-object v1, p0, Lco/vine/android/views/HorizontalListView$Recycler;->mRecycleViews:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public clear()V
    .locals 6

    .prologue
    .line 1260
    iget-object v1, p0, Lco/vine/android/views/HorizontalListView$Recycler;->mRecycleViews:Ljava/util/ArrayList;

    .line 1261
    .local v1, "recycledViews":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v2

    .line 1262
    .local v2, "size":I
    add-int/lit8 v0, v2, -0x1

    .local v0, "i":I
    :goto_0
    if-ltz v0, :cond_0

    .line 1263
    iget-object v4, p0, Lco/vine/android/views/HorizontalListView$Recycler;->this$0:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/view/View;

    const/4 v5, 0x0

    # invokes: Lco/vine/android/views/HorizontalListView;->removeDetachedView(Landroid/view/View;Z)V
    invoke-static {v4, v3, v5}, Lco/vine/android/views/HorizontalListView;->access$700(Lco/vine/android/views/HorizontalListView;Landroid/view/View;Z)V

    .line 1262
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 1265
    :cond_0
    return-void
.end method

.method public fillActiveViews(II)V
    .locals 3
    .param p1, "position"    # I
    .param p2, "childCount"    # I

    .prologue
    .line 1219
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView$Recycler;->mActiveViews:[Landroid/view/View;

    .line 1220
    .local v0, "activeViews":[Landroid/view/View;
    if-eqz v0, :cond_0

    array-length v2, v0

    if-ge v2, p2, :cond_1

    .line 1221
    :cond_0
    new-array v2, p2, [Landroid/view/View;

    iput-object v2, p0, Lco/vine/android/views/HorizontalListView$Recycler;->mActiveViews:[Landroid/view/View;

    .line 1222
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView$Recycler;->mActiveViews:[Landroid/view/View;

    .line 1224
    :cond_1
    iput p1, p0, Lco/vine/android/views/HorizontalListView$Recycler;->mFirstActivePos:I

    .line 1225
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, p2, :cond_2

    .line 1226
    iget-object v2, p0, Lco/vine/android/views/HorizontalListView$Recycler;->this$0:Lco/vine/android/views/HorizontalListView;

    invoke-virtual {v2, v1}, Lco/vine/android/views/HorizontalListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    aput-object v2, v0, v1

    .line 1225
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 1228
    :cond_2
    return-void
.end method

.method public getActiveView(I)Landroid/view/View;
    .locals 5
    .param p1, "position"    # I

    .prologue
    const/4 v3, 0x0

    .line 1172
    iget-object v4, p0, Lco/vine/android/views/HorizontalListView$Recycler;->mActiveViews:[Landroid/view/View;

    if-eqz v4, :cond_0

    .line 1173
    iget v4, p0, Lco/vine/android/views/HorizontalListView$Recycler;->mFirstActivePos:I

    sub-int v1, p1, v4

    .line 1174
    .local v1, "index":I
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView$Recycler;->mActiveViews:[Landroid/view/View;

    .line 1175
    .local v0, "activeViews":[Landroid/view/View;
    if-ltz v1, :cond_0

    array-length v4, v0

    if-ge v1, v4, :cond_0

    .line 1176
    aget-object v2, v0, v1

    .line 1177
    .local v2, "v":Landroid/view/View;
    aput-object v3, v0, v1

    .line 1181
    .end local v0    # "activeViews":[Landroid/view/View;
    .end local v1    # "index":I
    .end local v2    # "v":Landroid/view/View;
    :goto_0
    return-object v2

    :cond_0
    move-object v2, v3

    goto :goto_0
.end method

.method public recycleActiveViews()V
    .locals 7

    .prologue
    .line 1185
    iget-object v0, p0, Lco/vine/android/views/HorizontalListView$Recycler;->mActiveViews:[Landroid/view/View;

    .line 1186
    .local v0, "activeViews":[Landroid/view/View;
    if-nez v0, :cond_0

    .line 1204
    :goto_0
    return-void

    .line 1189
    :cond_0
    iget-object v4, p0, Lco/vine/android/views/HorizontalListView$Recycler;->mRecycleViews:Ljava/util/ArrayList;

    .line 1190
    .local v4, "recycledViews":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    array-length v1, v0

    .line 1192
    .local v1, "count":I
    add-int/lit8 v2, v1, -0x1

    .local v2, "i":I
    :goto_1
    if-ltz v2, :cond_2

    .line 1193
    aget-object v5, v0, v2

    .line 1194
    .local v5, "victim":Landroid/view/View;
    if-eqz v5, :cond_1

    .line 1195
    invoke-virtual {v5}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    check-cast v3, Lco/vine/android/views/HorizontalListView$LayoutParams;

    .line 1196
    .local v3, "lp":Lco/vine/android/views/HorizontalListView$LayoutParams;
    const/4 v6, 0x0

    aput-object v6, v0, v2

    .line 1198
    iget v6, p0, Lco/vine/android/views/HorizontalListView$Recycler;->mFirstActivePos:I

    add-int/2addr v6, v2

    iput v6, v3, Lco/vine/android/views/HorizontalListView$LayoutParams;->recycledPosition:I

    .line 1199
    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1192
    .end local v3    # "lp":Lco/vine/android/views/HorizontalListView$LayoutParams;
    :cond_1
    add-int/lit8 v2, v2, -0x1

    goto :goto_1

    .line 1203
    .end local v5    # "victim":Landroid/view/View;
    :cond_2
    invoke-direct {p0}, Lco/vine/android/views/HorizontalListView$Recycler;->pruneRecycleViews()V

    goto :goto_0
.end method

.method public removeRecycleView(I)Landroid/view/View;
    .locals 5
    .param p1, "position"    # I

    .prologue
    .line 1231
    iget-object v1, p0, Lco/vine/android/views/HorizontalListView$Recycler;->mRecycleViews:Ljava/util/ArrayList;

    .line 1232
    .local v1, "recycledViews":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/view/View;>;"
    invoke-virtual {v1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 1233
    const/4 v3, 0x0

    .line 1244
    :goto_0
    return-object v3

    .line 1235
    :cond_0
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v2

    .line 1237
    .local v2, "size":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    if-ge v0, v2, :cond_2

    .line 1238
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/view/View;

    .line 1239
    .local v3, "view":Landroid/view/View;
    invoke-virtual {v3}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v4

    check-cast v4, Lco/vine/android/views/HorizontalListView$LayoutParams;

    iget v4, v4, Lco/vine/android/views/HorizontalListView$LayoutParams;->recycledPosition:I

    if-ne v4, p1, :cond_1

    .line 1240
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    goto :goto_0

    .line 1237
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 1244
    .end local v3    # "view":Landroid/view/View;
    :cond_2
    add-int/lit8 v4, v2, -0x1

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/view/View;

    move-object v3, v4

    goto :goto_0
.end method

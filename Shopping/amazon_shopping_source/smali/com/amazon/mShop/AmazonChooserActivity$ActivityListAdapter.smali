.class Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;
.super Landroid/widget/BaseAdapter;
.source "AmazonChooserActivity.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;
.implements Landroid/widget/ListAdapter;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/AmazonChooserActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ActivityListAdapter"
.end annotation


# instance fields
.field protected mActivity:Lcom/amazon/mShop/AmazonChooserActivity;

.field protected mDialog:Lcom/amazon/mShop/AmazonAlertDialog;

.field protected mLayoutInflater:Landroid/view/LayoutInflater;

.field private mNeedRedraw:Z

.field private mPackManager:Landroid/content/pm/PackageManager;

.field protected mPackageIconMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Landroid/graphics/drawable/Drawable;",
            ">;"
        }
    .end annotation
.end field

.field private mResolveInfoList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/content/pm/ResolveInfo;",
            ">;"
        }
    .end annotation
.end field

.field protected mTargetIntent:Landroid/content/Intent;

.field final synthetic this$0:Lcom/amazon/mShop/AmazonChooserActivity;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonChooserActivity;Ljava/util/List;Landroid/content/Intent;Lcom/amazon/mShop/AmazonAlertDialog;)V
    .locals 1
    .param p3, "targetIntent"    # Landroid/content/Intent;
    .param p4, "dialog"    # Lcom/amazon/mShop/AmazonAlertDialog;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/content/pm/ResolveInfo;",
            ">;",
            "Landroid/content/Intent;",
            "Lcom/amazon/mShop/AmazonAlertDialog;",
            ")V"
        }
    .end annotation

    .prologue
    .local p2, "infoList":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    const/4 v0, 0x0

    .line 238
    iput-object p1, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->this$0:Lcom/amazon/mShop/AmazonChooserActivity;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 227
    iput-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mActivity:Lcom/amazon/mShop/AmazonChooserActivity;

    .line 228
    iput-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mResolveInfoList:Ljava/util/List;

    .line 229
    iput-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mTargetIntent:Landroid/content/Intent;

    .line 230
    iput-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mLayoutInflater:Landroid/view/LayoutInflater;

    .line 231
    iput-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mPackManager:Landroid/content/pm/PackageManager;

    .line 234
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mPackageIconMap:Ljava/util/Map;

    .line 235
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mNeedRedraw:Z

    .line 239
    iput-object p1, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mActivity:Lcom/amazon/mShop/AmazonChooserActivity;

    .line 240
    iput-object p2, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mResolveInfoList:Ljava/util/List;

    .line 241
    iput-object p3, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mTargetIntent:Landroid/content/Intent;

    .line 242
    iget-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mActivity:Lcom/amazon/mShop/AmazonChooserActivity;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mLayoutInflater:Landroid/view/LayoutInflater;

    .line 243
    iget-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mActivity:Lcom/amazon/mShop/AmazonChooserActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonChooserActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mPackManager:Landroid/content/pm/PackageManager;

    .line 244
    iput-object p4, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    .line 245
    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;)Landroid/content/pm/PackageManager;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;

    .prologue
    .line 224
    iget-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mPackManager:Landroid/content/pm/PackageManager;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;

    .prologue
    .line 224
    iget-boolean v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mNeedRedraw:Z

    return v0
.end method

.method static synthetic access$302(Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;
    .param p1, "x1"    # Z

    .prologue
    .line 224
    iput-boolean p1, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mNeedRedraw:Z

    return p1
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 249
    iget-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mResolveInfoList:Ljava/util/List;

    if-nez v0, :cond_0

    .line 250
    const/4 v0, 0x0

    .line 252
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mResolveInfoList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    goto :goto_0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 257
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 262
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 7
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 267
    move-object v6, p2

    .line 269
    .local v6, "itemView":Landroid/view/View;
    iget-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mResolveInfoList:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mResolveInfoList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 270
    iget-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mResolveInfoList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/content/pm/ResolveInfo;

    .line 275
    .local v5, "inf":Landroid/content/pm/ResolveInfo;
    iget-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mPackManager:Landroid/content/pm/PackageManager;

    invoke-virtual {v5, v0}, Landroid/content/pm/ResolveInfo;->loadLabel(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;

    move-result-object v2

    .line 277
    .local v2, "label":Ljava/lang/CharSequence;
    iget-object v0, v5, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v4, v0, Landroid/content/pm/ActivityInfo;->packageName:Ljava/lang/String;

    .line 279
    .local v4, "packageName":Ljava/lang/String;
    const/4 v3, 0x0

    move-object v0, p0

    move-object v1, p2

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->populateItemView(Landroid/view/View;Ljava/lang/CharSequence;Landroid/graphics/drawable/Drawable;Ljava/lang/String;Landroid/content/pm/ResolveInfo;)Landroid/view/View;

    move-result-object v6

    .line 281
    .end local v2    # "label":Ljava/lang/CharSequence;
    .end local v4    # "packageName":Ljava/lang/String;
    .end local v5    # "inf":Landroid/content/pm/ResolveInfo;
    :cond_0
    return-object v6
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 3
    .param p2, "itemView"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "viewId"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 286
    .local p1, "parentView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mResolveInfoList:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 287
    iget-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mResolveInfoList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 289
    iget-object v1, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mActivity:Lcom/amazon/mShop/AmazonChooserActivity;

    iget-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mResolveInfoList:Ljava/util/List;

    invoke-interface {v0, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/pm/ResolveInfo;

    iget-object v2, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mTargetIntent:Landroid/content/Intent;

    # invokes: Lcom/amazon/mShop/AmazonChooserActivity;->startResolvedActivity(Landroid/content/pm/ResolveInfo;Landroid/content/Intent;)V
    invoke-static {v1, v0, v2}, Lcom/amazon/mShop/AmazonChooserActivity;->access$000(Lcom/amazon/mShop/AmazonChooserActivity;Landroid/content/pm/ResolveInfo;Landroid/content/Intent;)V

    .line 290
    iget-object v1, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->this$0:Lcom/amazon/mShop/AmazonChooserActivity;

    iget-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mResolveInfoList:Ljava/util/List;

    invoke-interface {v0, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/pm/ResolveInfo;

    iget-object v0, v0, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v0, v0, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    const/4 v2, -0x1

    # invokes: Lcom/amazon/mShop/AmazonChooserActivity;->setSeletedResult(Ljava/lang/String;I)V
    invoke-static {v1, v0, v2}, Lcom/amazon/mShop/AmazonChooserActivity;->access$100(Lcom/amazon/mShop/AmazonChooserActivity;Ljava/lang/String;I)V

    .line 294
    iget-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->dismiss()V

    .line 297
    :cond_0
    return-void
.end method

.method protected populateItemView(Landroid/view/View;Ljava/lang/CharSequence;Landroid/graphics/drawable/Drawable;Ljava/lang/String;Landroid/content/pm/ResolveInfo;)Landroid/view/View;
    .locals 8
    .param p1, "convertView"    # Landroid/view/View;
    .param p2, "label"    # Ljava/lang/CharSequence;
    .param p3, "icon"    # Landroid/graphics/drawable/Drawable;
    .param p4, "packageName"    # Ljava/lang/String;
    .param p5, "resolveInfo"    # Landroid/content/pm/ResolveInfo;

    .prologue
    const/4 v7, 0x0

    .line 301
    move-object v2, p1

    .line 303
    .local v2, "itemView":Landroid/view/View;
    const/4 v4, 0x0

    .line 304
    .local v4, "tag":Ljava/lang/String;
    if-eqz p1, :cond_0

    .line 305
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v4

    .end local v4    # "tag":Ljava/lang/String;
    check-cast v4, Ljava/lang/String;

    .line 308
    .restart local v4    # "tag":Ljava/lang/String;
    :cond_0
    if-eqz p4, :cond_2

    if-eqz v4, :cond_2

    invoke-virtual {p4, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 309
    move-object v2, p1

    .line 315
    :goto_0
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->resolve_list_item_app_icon:I

    invoke-virtual {v2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 317
    .local v0, "appIcon":Landroid/widget/ImageView;
    iget-object v5, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mPackageIconMap:Ljava/util/Map;

    invoke-interface {v5, p4}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 318
    iget-object v5, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mPackageIconMap:Ljava/util/Map;

    invoke-interface {v5, p4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/graphics/drawable/Drawable;

    .line 319
    .local v3, "savedIcon":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 320
    if-nez v3, :cond_1

    .line 323
    const/4 v5, 0x1

    iput-boolean v5, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mNeedRedraw:Z

    .line 365
    .end local v3    # "savedIcon":Landroid/graphics/drawable/Drawable;
    :cond_1
    :goto_1
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->resolve_list_item_app_name:I

    invoke-virtual {v2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 366
    .local v1, "appName":Landroid/widget/TextView;
    invoke-virtual {v1, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 367
    return-object v2

    .line 311
    .end local v0    # "appIcon":Landroid/widget/ImageView;
    .end local v1    # "appName":Landroid/widget/TextView;
    :cond_2
    iget-object v5, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mLayoutInflater:Landroid/view/LayoutInflater;

    sget v6, Lcom/amazon/mShop/android/lib/R$layout;->resolve_list_item:I

    invoke-virtual {v5, v6, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 312
    invoke-virtual {v2, p4}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    goto :goto_0

    .line 325
    .restart local v0    # "appIcon":Landroid/widget/ImageView;
    :cond_3
    if-eqz p3, :cond_4

    .line 327
    iget-object v5, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mPackageIconMap:Ljava/util/Map;

    invoke-interface {v5, p4, p3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 328
    invoke-virtual {v0, p3}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_1

    .line 332
    :cond_4
    if-eqz p5, :cond_1

    .line 335
    iget-object v5, p0, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;->mPackageIconMap:Ljava/util/Map;

    invoke-interface {v5, p4, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 336
    invoke-virtual {v0, v7}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 338
    new-instance v5, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1;

    invoke-direct {v5, p0, p5, p4, v0}, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1;-><init>(Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;Landroid/content/pm/ResolveInfo;Ljava/lang/String;Landroid/widget/ImageView;)V

    invoke-static {v5}, Lcom/amazon/mShop/util/BitmapUtil;->tryInCaseOfOutOfMemory(Ljava/lang/Runnable;)V

    goto :goto_1
.end method

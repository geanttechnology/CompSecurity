.class public Lcom/livemixtapes/CommentsPopup;
.super Ljava/lang/Object;
.source "CommentsPopup.java"


# instance fields
.field mActivity:Landroid/app/Activity;

.field mContext:Landroid/content/Context;

.field mixtape:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/app/Activity;Landroid/content/Context;Ljava/util/Map;)V
    .locals 0
    .param p1, "mActivity"    # Landroid/app/Activity;
    .param p2, "mContext"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Landroid/content/Context;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 40
    .local p3, "mixtape":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    iput-object p1, p0, Lcom/livemixtapes/CommentsPopup;->mActivity:Landroid/app/Activity;

    .line 43
    iput-object p2, p0, Lcom/livemixtapes/CommentsPopup;->mContext:Landroid/content/Context;

    .line 44
    iput-object p3, p0, Lcom/livemixtapes/CommentsPopup;->mixtape:Ljava/util/Map;

    .line 45
    return-void
.end method


# virtual methods
.method public getLocalUriFromBitmap(Landroid/graphics/Bitmap;)Landroid/net/Uri;
    .locals 8
    .param p1, "bmp"    # Landroid/graphics/Bitmap;

    .prologue
    .line 219
    const/4 v0, 0x0

    .line 221
    .local v0, "bmpUri":Landroid/net/Uri;
    :try_start_0
    new-instance v2, Ljava/io/File;

    .line 223
    sget-object v4, Landroid/os/Environment;->DIRECTORY_DOWNLOADS:Ljava/lang/String;

    invoke-static {v4}, Landroid/os/Environment;->getExternalStoragePublicDirectory(Ljava/lang/String;)Ljava/io/File;

    move-result-object v4

    .line 224
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "share_image_"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    invoke-virtual {v5, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ".png"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 221
    invoke-direct {v2, v4, v5}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 225
    .local v2, "file":Ljava/io/File;
    invoke-virtual {v2}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->mkdirs()Z

    .line 226
    new-instance v3, Ljava/io/FileOutputStream;

    invoke-direct {v3, v2}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 227
    .local v3, "out":Ljava/io/FileOutputStream;
    sget-object v4, Landroid/graphics/Bitmap$CompressFormat;->PNG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v5, 0x5a

    invoke-virtual {p1, v4, v5, v3}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 228
    invoke-virtual {v3}, Ljava/io/FileOutputStream;->close()V

    .line 229
    invoke-static {v2}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 233
    .end local v2    # "file":Ljava/io/File;
    .end local v3    # "out":Ljava/io/FileOutputStream;
    :goto_0
    return-object v0

    .line 230
    :catch_0
    move-exception v1

    .line 231
    .local v1, "e":Ljava/io/IOException;
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0
.end method

.method shareSocialNetworks(Ljava/lang/String;)V
    .locals 11
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    .line 189
    new-instance v7, Landroid/content/Intent;

    const-string v8, "android.intent.action.SEND"

    invoke-direct {v7, v8}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 190
    .local v7, "shareIntent":Landroid/content/Intent;
    const-string v8, "text/plain"

    invoke-virtual {v7, v8}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 191
    const-string v8, "com.instagram.android"

    invoke-virtual {p1, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 192
    const-string v8, "image/*"

    invoke-virtual {v7, v8}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 193
    :cond_0
    const-string v9, "android.intent.extra.TEXT"

    .line 194
    iget-object v8, p0, Lcom/livemixtapes/CommentsPopup;->mixtape:Ljava/util/Map;

    const-string v10, "sharetext"

    invoke-interface {v8, v10}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    .line 193
    invoke-virtual {v7, v9, v8}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 195
    new-instance v4, Lcom/livemixtapes/ImageLoader;

    iget-object v8, p0, Lcom/livemixtapes/CommentsPopup;->mContext:Landroid/content/Context;

    invoke-direct {v4, v8}, Lcom/livemixtapes/ImageLoader;-><init>(Landroid/content/Context;)V

    .line 196
    .local v4, "imageLoader":Lcom/livemixtapes/ImageLoader;
    iget-object v8, p0, Lcom/livemixtapes/CommentsPopup;->mixtape:Ljava/util/Map;

    const-string v9, "cover"

    invoke-interface {v8, v9}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-virtual {v4, v8}, Lcom/livemixtapes/ImageLoader;->getBitmap(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v3

    .line 197
    .local v3, "bt":Landroid/graphics/Bitmap;
    const-string v8, "android.intent.extra.STREAM"

    invoke-virtual {p0, v3}, Lcom/livemixtapes/CommentsPopup;->getLocalUriFromBitmap(Landroid/graphics/Bitmap;)Landroid/net/Uri;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 199
    iget-object v8, p0, Lcom/livemixtapes/CommentsPopup;->mActivity:Landroid/app/Activity;

    invoke-virtual {v8}, Landroid/app/Activity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v6

    .line 201
    .local v6, "pm":Landroid/content/pm/PackageManager;
    const/4 v8, 0x0

    .line 200
    invoke-virtual {v6, v7, v8}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v1

    .line 202
    .local v1, "activityList":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :cond_1
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-nez v9, :cond_2

    .line 215
    :goto_0
    return-void

    .line 202
    :cond_2
    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/content/pm/ResolveInfo;

    .line 203
    .local v2, "app":Landroid/content/pm/ResolveInfo;
    iget-object v9, v2, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v9, v9, Landroid/content/pm/ActivityInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v9, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 204
    iget-object v0, v2, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    .line 205
    .local v0, "activity":Landroid/content/pm/ActivityInfo;
    new-instance v5, Landroid/content/ComponentName;

    .line 206
    iget-object v8, v0, Landroid/content/pm/ActivityInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v8, v8, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    iget-object v9, v0, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    .line 205
    invoke-direct {v5, v8, v9}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 207
    .local v5, "name":Landroid/content/ComponentName;
    const-string v8, "android.intent.category.LAUNCHER"

    invoke-virtual {v7, v8}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 208
    const/high16 v8, 0x10200000

    invoke-virtual {v7, v8}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 210
    invoke-virtual {v7, v5}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    .line 211
    iget-object v8, p0, Lcom/livemixtapes/CommentsPopup;->mActivity:Landroid/app/Activity;

    invoke-virtual {v8, v7}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method showPopup(Landroid/widget/FrameLayout;Landroid/widget/ImageButton;)V
    .locals 23
    .param p1, "frameLayout"    # Landroid/widget/FrameLayout;
    .param p2, "comments"    # Landroid/widget/ImageButton;

    .prologue
    .line 49
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/CommentsPopup;->mActivity:Landroid/app/Activity;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Landroid/app/Activity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v20

    invoke-interface/range {v20 .. v20}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v7

    .line 50
    .local v7, "display":Landroid/view/Display;
    new-instance v15, Landroid/graphics/Point;

    invoke-direct {v15}, Landroid/graphics/Point;-><init>()V

    .line 51
    .local v15, "size":Landroid/graphics/Point;
    invoke-virtual {v7, v15}, Landroid/view/Display;->getSize(Landroid/graphics/Point;)V

    .line 52
    iget v0, v15, Landroid/graphics/Point;->x:I

    move/from16 v19, v0

    .line 53
    .local v19, "width":I
    iget v10, v15, Landroid/graphics/Point;->y:I

    .line 55
    .local v10, "height":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/CommentsPopup;->mContext:Landroid/content/Context;

    move-object/from16 v20, v0

    .line 56
    const-string v21, "layout_inflater"

    invoke-virtual/range {v20 .. v21}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v12

    .line 55
    check-cast v12, Landroid/view/LayoutInflater;

    .line 58
    .local v12, "layoutInflater":Landroid/view/LayoutInflater;
    const v20, 0x7f03001b

    const/16 v21, 0x0

    .line 57
    move/from16 v0, v20

    move-object/from16 v1, v21

    invoke-virtual {v12, v0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v13

    .line 59
    .local v13, "popupView":Landroid/view/View;
    new-instance v14, Landroid/widget/PopupWindow;

    .line 60
    mul-int/lit8 v20, v19, 0x3

    div-int/lit8 v20, v20, 0x4

    mul-int/lit8 v21, v10, 0x3

    div-int/lit8 v21, v21, 0x5

    .line 59
    move/from16 v0, v20

    move/from16 v1, v21

    invoke-direct {v14, v13, v0, v1}, Landroid/widget/PopupWindow;-><init>(Landroid/view/View;II)V

    .line 61
    .local v14, "popupWindow":Landroid/widget/PopupWindow;
    const v20, 0x1030002

    move/from16 v0, v20

    invoke-virtual {v14, v0}, Landroid/widget/PopupWindow;->setAnimationStyle(I)V

    .line 62
    const/16 v20, 0x1

    move/from16 v0, v20

    invoke-virtual {v14, v0}, Landroid/widget/PopupWindow;->setOutsideTouchable(Z)V

    .line 63
    const/16 v20, 0x1

    move/from16 v0, v20

    invoke-virtual {v14, v0}, Landroid/widget/PopupWindow;->setFocusable(Z)V

    .line 64
    new-instance v20, Landroid/graphics/drawable/ColorDrawable;

    .line 65
    const/16 v21, 0x0

    invoke-direct/range {v20 .. v21}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    .line 64
    move-object/from16 v0, v20

    invoke-virtual {v14, v0}, Landroid/widget/PopupWindow;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 67
    const/16 v20, 0x11

    const/16 v21, 0x0

    const/16 v22, 0x28

    move-object/from16 v0, p2

    move/from16 v1, v20

    move/from16 v2, v21

    move/from16 v3, v22

    invoke-virtual {v14, v0, v1, v2, v3}, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View;III)V

    .line 68
    new-instance v20, Lcom/livemixtapes/CommentsPopup$1;

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    move-object/from16 v2, p1

    invoke-direct {v0, v1, v2}, Lcom/livemixtapes/CommentsPopup$1;-><init>(Lcom/livemixtapes/CommentsPopup;Landroid/widget/FrameLayout;)V

    move-object/from16 v0, v20

    invoke-virtual {v14, v0}, Landroid/widget/PopupWindow;->setOnDismissListener(Landroid/widget/PopupWindow$OnDismissListener;)V

    .line 77
    const v20, 0x7f080063

    move/from16 v0, v20

    invoke-virtual {v13, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    .line 76
    check-cast v5, Landroid/widget/ImageButton;

    .line 78
    .local v5, "commentBtn":Landroid/widget/ImageButton;
    new-instance v20, Lcom/livemixtapes/CommentsPopup$2;

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v14}, Lcom/livemixtapes/CommentsPopup$2;-><init>(Lcom/livemixtapes/CommentsPopup;Landroid/widget/PopupWindow;)V

    move-object/from16 v0, v20

    invoke-virtual {v5, v0}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 91
    const v20, 0x7f08006b

    move/from16 v0, v20

    invoke-virtual {v13, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .line 90
    check-cast v4, Landroid/widget/ImageButton;

    .line 92
    .local v4, "closeBtn":Landroid/widget/ImageButton;
    new-instance v20, Lcom/livemixtapes/CommentsPopup$3;

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v14}, Lcom/livemixtapes/CommentsPopup$3;-><init>(Lcom/livemixtapes/CommentsPopup;Landroid/widget/PopupWindow;)V

    move-object/from16 v0, v20

    invoke-virtual {v4, v0}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 101
    const v20, 0x7f080064

    move/from16 v0, v20

    invoke-virtual {v13, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    .line 100
    check-cast v9, Landroid/widget/ImageButton;

    .line 102
    .local v9, "fbBtn":Landroid/widget/ImageButton;
    new-instance v20, Lcom/livemixtapes/CommentsPopup$4;

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v14}, Lcom/livemixtapes/CommentsPopup$4;-><init>(Lcom/livemixtapes/CommentsPopup;Landroid/widget/PopupWindow;)V

    move-object/from16 v0, v20

    invoke-virtual {v9, v0}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 111
    const v20, 0x7f080065

    move/from16 v0, v20

    invoke-virtual {v13, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v18

    .line 110
    check-cast v18, Landroid/widget/ImageButton;

    .line 112
    .local v18, "twitterBtn":Landroid/widget/ImageButton;
    new-instance v20, Lcom/livemixtapes/CommentsPopup$5;

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v14}, Lcom/livemixtapes/CommentsPopup$5;-><init>(Lcom/livemixtapes/CommentsPopup;Landroid/widget/PopupWindow;)V

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 121
    const v20, 0x7f080066

    move/from16 v0, v20

    invoke-virtual {v13, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v11

    .line 120
    check-cast v11, Landroid/widget/ImageButton;

    .line 122
    .local v11, "instagramBtn":Landroid/widget/ImageButton;
    new-instance v20, Lcom/livemixtapes/CommentsPopup$6;

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v14}, Lcom/livemixtapes/CommentsPopup$6;-><init>(Lcom/livemixtapes/CommentsPopup;Landroid/widget/PopupWindow;)V

    move-object/from16 v0, v20

    invoke-virtual {v11, v0}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 131
    const v20, 0x7f080068

    move/from16 v0, v20

    invoke-virtual {v13, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    .line 130
    check-cast v8, Landroid/widget/ImageButton;

    .line 132
    .local v8, "emailBtn":Landroid/widget/ImageButton;
    new-instance v20, Lcom/livemixtapes/CommentsPopup$7;

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v14}, Lcom/livemixtapes/CommentsPopup$7;-><init>(Lcom/livemixtapes/CommentsPopup;Landroid/widget/PopupWindow;)V

    move-object/from16 v0, v20

    invoke-virtual {v8, v0}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 149
    const v20, 0x7f080069

    move/from16 v0, v20

    invoke-virtual {v13, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v16

    .line 148
    check-cast v16, Landroid/widget/ImageButton;

    .line 150
    .local v16, "smsBtn":Landroid/widget/ImageButton;
    new-instance v20, Lcom/livemixtapes/CommentsPopup$8;

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v14}, Lcom/livemixtapes/CommentsPopup$8;-><init>(Lcom/livemixtapes/CommentsPopup;Landroid/widget/PopupWindow;)V

    move-object/from16 v0, v16

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 163
    const v20, 0x7f080067

    move/from16 v0, v20

    invoke-virtual {v13, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v17

    .line 162
    check-cast v17, Landroid/widget/ImageButton;

    .line 164
    .local v17, "tumblerBtn":Landroid/widget/ImageButton;
    new-instance v20, Lcom/livemixtapes/CommentsPopup$9;

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v14}, Lcom/livemixtapes/CommentsPopup$9;-><init>(Lcom/livemixtapes/CommentsPopup;Landroid/widget/PopupWindow;)V

    move-object/from16 v0, v17

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 173
    const v20, 0x7f08006a

    move/from16 v0, v20

    invoke-virtual {v13, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    .line 172
    check-cast v6, Landroid/widget/ImageButton;

    .line 174
    .local v6, "copyBtn":Landroid/widget/ImageButton;
    new-instance v20, Lcom/livemixtapes/CommentsPopup$10;

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v14}, Lcom/livemixtapes/CommentsPopup$10;-><init>(Lcom/livemixtapes/CommentsPopup;Landroid/widget/PopupWindow;)V

    move-object/from16 v0, v20

    invoke-virtual {v6, v0}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 185
    invoke-virtual/range {p1 .. p1}, Landroid/widget/FrameLayout;->getForeground()Landroid/graphics/drawable/Drawable;

    move-result-object v20

    const/16 v21, 0x87

    invoke-virtual/range {v20 .. v21}, Landroid/graphics/drawable/Drawable;->setAlpha(I)V

    .line 186
    return-void
.end method

.class Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;
.super Landroid/widget/BaseAdapter;
.source "BackedUpFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/fragments/BackedUpFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "MusicListAdapter"
.end annotation


# instance fields
.field private appName:Ljava/lang/String;

.field private my_delete_movie:Landroid/widget/ImageView;

.field private my_stop_download_bt:Landroid/widget/TextView;

.field final synthetic this$0:Lcom/aio/downloader/fragments/BackedUpFragment;

.field private tv_backupapksize:Landroid/widget/TextView;

.field private tv_backupapkversion:Landroid/widget/TextView;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/BackedUpFragment;)V
    .locals 0

    .prologue
    .line 168
    iput-object p1, p0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;)Lcom/aio/downloader/fragments/BackedUpFragment;
    .locals 1

    .prologue
    .line 168
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;

    return-object v0
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 177
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;

    # getter for: Lcom/aio/downloader/fragments/BackedUpFragment;->list:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpFragment;->access$3(Lcom/aio/downloader/fragments/BackedUpFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 181
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;

    # getter for: Lcom/aio/downloader/fragments/BackedUpFragment;->list:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpFragment;->access$3(Lcom/aio/downloader/fragments/BackedUpFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 185
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 22
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 190
    if-nez p2, :cond_0

    .line 191
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/aio/downloader/fragments/BackedUpFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Landroid/support/v4/app/FragmentActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v18

    .line 192
    const v19, 0x7f030069

    const/16 v20, 0x0

    .line 191
    invoke-virtual/range {v18 .. v20}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 195
    :cond_0
    const v18, 0x7f0700f0

    move-object/from16 v0, p2

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v15

    .line 194
    check-cast v15, Landroid/widget/TextView;

    .line 197
    .local v15, "tv_music_name":Landroid/widget/TextView;
    const v18, 0x7f0700ef

    move-object/from16 v0, p2

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v10

    .line 196
    check-cast v10, Landroid/widget/ImageView;

    .line 199
    .local v10, "iv":Landroid/widget/ImageView;
    const v18, 0x7f0700f2

    move-object/from16 v0, p2

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v18

    check-cast v18, Landroid/widget/TextView;

    .line 198
    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->my_stop_download_bt:Landroid/widget/TextView;

    .line 200
    const v18, 0x7f07027e

    move-object/from16 v0, p2

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v17

    .line 202
    .local v17, "view_backedup1":Landroid/view/View;
    const v18, 0x7f0700ee

    move-object/from16 v0, p2

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v18

    check-cast v18, Landroid/widget/ImageView;

    .line 201
    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->my_delete_movie:Landroid/widget/ImageView;

    .line 204
    const v18, 0x7f07027f

    move-object/from16 v0, p2

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v18

    check-cast v18, Landroid/widget/TextView;

    .line 203
    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->tv_backupapkversion:Landroid/widget/TextView;

    .line 206
    const v18, 0x7f070280

    move-object/from16 v0, p2

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v18

    check-cast v18, Landroid/widget/TextView;

    .line 205
    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->tv_backupapksize:Landroid/widget/TextView;

    .line 208
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;

    move-object/from16 v18, v0

    # getter for: Lcom/aio/downloader/fragments/BackedUpFragment;->list:Ljava/util/List;
    invoke-static/range {v18 .. v18}, Lcom/aio/downloader/fragments/BackedUpFragment;->access$3(Lcom/aio/downloader/fragments/BackedUpFragment;)Ljava/util/List;

    move-result-object v18

    move-object/from16 v0, v18

    move/from16 v1, p1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 210
    .local v6, "archiveFilePath":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/aio/downloader/fragments/BackedUpFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Landroid/support/v4/app/FragmentActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v14

    .line 212
    .local v14, "pm":Landroid/content/pm/PackageManager;
    const/16 v18, 0x1

    .line 211
    move/from16 v0, v18

    invoke-virtual {v14, v6, v0}, Landroid/content/pm/PackageManager;->getPackageArchiveInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v9

    .line 213
    .local v9, "info":Landroid/content/pm/PackageInfo;
    if-nez p1, :cond_2

    .line 214
    const/16 v18, 0x0

    invoke-virtual/range {v17 .. v18}, Landroid/view/View;->setVisibility(I)V

    .line 218
    :goto_0
    if-eqz v9, :cond_5

    .line 219
    iget-object v3, v9, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    .line 220
    .local v3, "appInfo":Landroid/content/pm/ApplicationInfo;
    iput-object v6, v3, Landroid/content/pm/ApplicationInfo;->sourceDir:Ljava/lang/String;

    .line 221
    iput-object v6, v3, Landroid/content/pm/ApplicationInfo;->publicSourceDir:Ljava/lang/String;

    .line 222
    invoke-virtual {v14, v3}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v18

    invoke-interface/range {v18 .. v18}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->appName:Ljava/lang/String;

    .line 223
    iget-object v13, v3, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    .line 224
    .local v13, "packageName":Ljava/lang/String;
    iget-object v0, v9, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    move-object/from16 v16, v0

    .line 225
    .local v16, "version":Ljava/lang/String;
    invoke-virtual {v14, v3}, Landroid/content/pm/PackageManager;->getApplicationIcon(Landroid/content/pm/ApplicationInfo;)Landroid/graphics/drawable/Drawable;

    move-result-object v8

    .line 226
    .local v8, "icon":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v10, v8}, Landroid/widget/ImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 227
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->appName:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 228
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->tv_backupapkversion:Landroid/widget/TextView;

    move-object/from16 v18, v0

    new-instance v19, Ljava/lang/StringBuilder;

    const-string v20, "Version:"

    invoke-direct/range {v19 .. v20}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v19

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 231
    :try_start_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/aio/downloader/fragments/BackedUpFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Landroid/support/v4/app/FragmentActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v18

    .line 232
    const/16 v19, 0x0

    move-object/from16 v0, v18

    move/from16 v1, v19

    invoke-virtual {v0, v13, v1}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v12

    .line 233
    .local v12, "packageInfo":Landroid/content/pm/PackageInfo;
    if-nez v12, :cond_3

    .line 234
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->my_stop_download_bt:Landroid/widget/TextView;

    move-object/from16 v18, v0

    const-string v19, "Install"

    invoke-virtual/range {v18 .. v19}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 243
    .end local v12    # "packageInfo":Landroid/content/pm/PackageInfo;
    :cond_1
    :goto_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->my_stop_download_bt:Landroid/widget/TextView;

    move-object/from16 v18, v0

    new-instance v19, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter$1;

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v13, v6}, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter$1;-><init>(Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual/range {v18 .. v19}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 276
    new-instance v18, Ljava/io/File;

    iget-object v0, v9, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    iget-object v0, v0, Landroid/content/pm/ApplicationInfo;->publicSourceDir:Ljava/lang/String;

    move-object/from16 v19, v0

    invoke-direct/range {v18 .. v19}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 277
    invoke-virtual/range {v18 .. v18}, Ljava/io/File;->length()J

    move-result-wide v18

    const-wide/16 v20, 0x400

    .line 276
    div-long v4, v18, v20

    .line 278
    .local v4, "appSize":J
    long-to-double v0, v4

    move-wide/from16 v18, v0

    const-wide/high16 v20, 0x4090000000000000L    # 1024.0

    div-double v18, v18, v20

    const-wide/high16 v20, 0x4059000000000000L    # 100.0

    mul-double v18, v18, v20

    move-wide/from16 v0, v18

    double-to-int v0, v0

    move/from16 v18, v0

    move/from16 v0, v18

    int-to-double v0, v0

    move-wide/from16 v18, v0

    const-wide/high16 v20, 0x4059000000000000L    # 100.0

    div-double v18, v18, v20

    move-wide/from16 v0, v18

    double-to-float v11, v0

    .line 279
    .local v11, "lastSize":F
    const-wide/16 v18, 0x400

    cmp-long v18, v4, v18

    if-ltz v18, :cond_4

    .line 280
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->tv_backupapksize:Landroid/widget/TextView;

    move-object/from16 v18, v0

    new-instance v19, Ljava/lang/StringBuilder;

    invoke-static {v11}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v20

    invoke-direct/range {v19 .. v20}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v20, "MB"

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 288
    .end local v3    # "appInfo":Landroid/content/pm/ApplicationInfo;
    .end local v4    # "appSize":J
    .end local v8    # "icon":Landroid/graphics/drawable/Drawable;
    .end local v11    # "lastSize":F
    .end local v13    # "packageName":Ljava/lang/String;
    .end local v16    # "version":Ljava/lang/String;
    :goto_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->my_delete_movie:Landroid/widget/ImageView;

    move-object/from16 v18, v0

    new-instance v19, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter$2;

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    move/from16 v2, p1

    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter$2;-><init>(Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;I)V

    invoke-virtual/range {v18 .. v19}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 305
    return-object p2

    .line 216
    :cond_2
    const/16 v18, 0x8

    invoke-virtual/range {v17 .. v18}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_0

    .line 236
    .restart local v3    # "appInfo":Landroid/content/pm/ApplicationInfo;
    .restart local v8    # "icon":Landroid/graphics/drawable/Drawable;
    .restart local v12    # "packageInfo":Landroid/content/pm/PackageInfo;
    .restart local v13    # "packageName":Ljava/lang/String;
    .restart local v16    # "version":Ljava/lang/String;
    :cond_3
    if-eqz v12, :cond_1

    .line 237
    :try_start_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->my_stop_download_bt:Landroid/widget/TextView;

    move-object/from16 v18, v0

    const-string v19, "Installed"

    invoke-virtual/range {v18 .. v19}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_1

    .line 240
    .end local v12    # "packageInfo":Landroid/content/pm/PackageInfo;
    :catch_0
    move-exception v7

    .line 241
    .local v7, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v7}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_1

    .line 282
    .end local v7    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    .restart local v4    # "appSize":J
    .restart local v11    # "lastSize":F
    :cond_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->tv_backupapksize:Landroid/widget/TextView;

    move-object/from16 v18, v0

    new-instance v19, Ljava/lang/StringBuilder;

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v20

    invoke-direct/range {v19 .. v20}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v20, "KB"

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_2

    .line 285
    .end local v3    # "appInfo":Landroid/content/pm/ApplicationInfo;
    .end local v4    # "appSize":J
    .end local v8    # "icon":Landroid/graphics/drawable/Drawable;
    .end local v11    # "lastSize":F
    .end local v13    # "packageName":Ljava/lang/String;
    .end local v16    # "version":Ljava/lang/String;
    :cond_5
    const v18, 0x7f02006f

    move/from16 v0, v18

    invoke-virtual {v10, v0}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 286
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->appName:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_2
.end method

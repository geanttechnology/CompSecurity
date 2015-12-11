.class Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;
.super Landroid/widget/BaseAdapter;
.source "BackedUpNoRootFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/fragments/BackedUpNoRootFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "MusicListAdapter"
.end annotation


# instance fields
.field private appName:Ljava/lang/String;

.field private my_delete_movie:Landroid/widget/ImageView;

.field private my_stop_download_bt:Landroid/widget/TextView;

.field private packageName:Ljava/lang/String;

.field final synthetic this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

.field private tv_backupapksize:Landroid/widget/TextView;

.field private tv_backupapkversion:Landroid/widget/TextView;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)V
    .locals 0

    .prologue
    .line 126
    iput-object p1, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;)Lcom/aio/downloader/fragments/BackedUpNoRootFragment;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    return-object v0
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->listdd:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->access$2(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 140
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 144
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 12
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 149
    if-nez p2, :cond_0

    .line 150
    iget-object v9, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    invoke-virtual {v9}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v9

    invoke-virtual {v9}, Landroid/support/v4/app/FragmentActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v9

    .line 151
    const v10, 0x7f030069

    const/4 v11, 0x0

    .line 150
    invoke-virtual {v9, v10, v11}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 154
    :cond_0
    const v9, 0x7f0700f0

    invoke-virtual {p2, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    .line 153
    check-cast v7, Landroid/widget/TextView;

    .line 156
    .local v7, "tv_music_name":Landroid/widget/TextView;
    const v9, 0x7f0700ef

    invoke-virtual {p2, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .line 155
    check-cast v4, Landroid/widget/ImageView;

    .line 158
    .local v4, "iv":Landroid/widget/ImageView;
    const v9, 0x7f0700f2

    invoke-virtual {p2, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/TextView;

    .line 157
    iput-object v9, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->my_stop_download_bt:Landroid/widget/TextView;

    .line 159
    const v9, 0x7f07027e

    invoke-virtual {p2, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    .line 161
    .local v8, "view_backedup1":Landroid/view/View;
    const v9, 0x7f0700ee

    invoke-virtual {p2, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/ImageView;

    .line 160
    iput-object v9, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->my_delete_movie:Landroid/widget/ImageView;

    .line 163
    const v9, 0x7f07027f

    invoke-virtual {p2, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/TextView;

    .line 162
    iput-object v9, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->tv_backupapkversion:Landroid/widget/TextView;

    .line 165
    const v9, 0x7f070280

    invoke-virtual {p2, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/TextView;

    .line 164
    iput-object v9, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->tv_backupapksize:Landroid/widget/TextView;

    .line 166
    if-nez p1, :cond_2

    .line 167
    const/4 v9, 0x0

    invoke-virtual {v8, v9}, Landroid/view/View;->setVisibility(I)V

    .line 172
    :goto_0
    iget-object v9, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->listdd:Ljava/util/List;
    invoke-static {v9}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->access$2(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)Ljava/util/List;

    move-result-object v9

    invoke-interface {v9, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/aio/downloader/model/BackupModel;

    .line 173
    invoke-virtual {v9}, Lcom/aio/downloader/model/BackupModel;->getPackage_name()Ljava/lang/String;

    move-result-object v0

    .line 175
    .local v0, "archiveFilePath":Ljava/lang/String;
    const/4 v5, 0x0

    .line 177
    .local v5, "pI":Landroid/content/pm/PackageInfo;
    :try_start_0
    iget-object v9, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    invoke-virtual {v9}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v9

    invoke-virtual {v9}, Landroid/support/v4/app/FragmentActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v9

    .line 178
    const/4 v10, 0x0

    .line 177
    invoke-virtual {v9, v0, v10}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    .line 205
    :goto_1
    iget-object v9, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->listdd:Ljava/util/List;
    invoke-static {v9}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->access$2(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)Ljava/util/List;

    move-result-object v9

    invoke-interface {v9, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/aio/downloader/model/BackupModel;

    invoke-virtual {v9}, Lcom/aio/downloader/model/BackupModel;->getApp_name()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 206
    iget-object v10, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->tv_backupapkversion:Landroid/widget/TextView;

    new-instance v11, Ljava/lang/StringBuilder;

    const-string v9, "Version:"

    invoke-direct {v11, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v9, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->listdd:Ljava/util/List;
    invoke-static {v9}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->access$2(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)Ljava/util/List;

    move-result-object v9

    invoke-interface {v9, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/aio/downloader/model/BackupModel;

    invoke-virtual {v9}, Lcom/aio/downloader/model/BackupModel;->getVersion()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v11, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v10, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 207
    iget-object v10, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->tv_backupapksize:Landroid/widget/TextView;

    iget-object v9, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->listdd:Ljava/util/List;
    invoke-static {v9}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->access$2(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)Ljava/util/List;

    move-result-object v9

    invoke-interface {v9, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/aio/downloader/model/BackupModel;

    invoke-virtual {v9}, Lcom/aio/downloader/model/BackupModel;->getSize()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v10, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 208
    iget-object v9, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->listdd:Ljava/util/List;
    invoke-static {v9}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->access$2(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)Ljava/util/List;

    move-result-object v9

    invoke-interface {v9, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/aio/downloader/model/BackupModel;

    invoke-virtual {v9}, Lcom/aio/downloader/model/BackupModel;->getImg()Ljava/lang/String;

    move-result-object v3

    .line 209
    .local v3, "img":Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->stringtoBitmap(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v6

    .line 210
    .local v6, "stringtoBitmap":Landroid/graphics/Bitmap;
    iget-object v9, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    invoke-virtual {v9, v6}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->bitmap2Drawable(Landroid/graphics/Bitmap;)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 211
    .local v1, "bitmap2Drawable":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v4, v1}, Landroid/widget/ImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 212
    if-nez v5, :cond_3

    .line 213
    iget-object v9, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->my_stop_download_bt:Landroid/widget/TextView;

    const-string v10, "Install"

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 219
    :cond_1
    :goto_2
    iget-object v9, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->my_stop_download_bt:Landroid/widget/TextView;

    new-instance v10, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$1;

    invoke-direct {v10, p0, v0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$1;-><init>(Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;Ljava/lang/String;)V

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 248
    iget-object v9, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->my_delete_movie:Landroid/widget/ImageView;

    new-instance v10, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$2;

    invoke-direct {v10, p0, p1}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$2;-><init>(Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;I)V

    invoke-virtual {v9, v10}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 268
    return-object p2

    .line 169
    .end local v0    # "archiveFilePath":Ljava/lang/String;
    .end local v1    # "bitmap2Drawable":Landroid/graphics/drawable/Drawable;
    .end local v3    # "img":Ljava/lang/String;
    .end local v5    # "pI":Landroid/content/pm/PackageInfo;
    .end local v6    # "stringtoBitmap":Landroid/graphics/Bitmap;
    :cond_2
    const/16 v9, 0x8

    invoke-virtual {v8, v9}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_0

    .line 179
    .restart local v0    # "archiveFilePath":Ljava/lang/String;
    .restart local v5    # "pI":Landroid/content/pm/PackageInfo;
    :catch_0
    move-exception v2

    .line 180
    .local v2, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v2}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_1

    .line 215
    .end local v2    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    .restart local v1    # "bitmap2Drawable":Landroid/graphics/drawable/Drawable;
    .restart local v3    # "img":Ljava/lang/String;
    .restart local v6    # "stringtoBitmap":Landroid/graphics/Bitmap;
    :cond_3
    if-eqz v5, :cond_1

    .line 216
    iget-object v9, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->my_stop_download_bt:Landroid/widget/TextView;

    const-string v10, "Installed"

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_2
.end method

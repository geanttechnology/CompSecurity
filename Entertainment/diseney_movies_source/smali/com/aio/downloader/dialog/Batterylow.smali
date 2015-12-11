.class public Lcom/aio/downloader/dialog/Batterylow;
.super Landroid/app/Dialog;
.source "Batterylow.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/dialog/Batterylow$OnCustomDialogListener;
    }
.end annotation


# instance fields
.field private batterycancel:Landroid/widget/Button;

.field private ctx:Landroid/content/Context;

.field private infos:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/model/Info;",
            ">;"
        }
    .end annotation
.end field

.field private itemsOnClick:Landroid/view/View$OnClickListener;

.field private iv_icon_ins1:Lcom/aio/downloader/views/RoundImageView;

.field private iv_icon_ins10:Lcom/aio/downloader/views/RoundImageView;

.field private iv_icon_ins2:Lcom/aio/downloader/views/RoundImageView;

.field private iv_icon_ins3:Lcom/aio/downloader/views/RoundImageView;

.field private iv_icon_ins4:Lcom/aio/downloader/views/RoundImageView;

.field private iv_icon_ins5:Lcom/aio/downloader/views/RoundImageView;

.field private iv_icon_ins6:Lcom/aio/downloader/views/RoundImageView;

.field private iv_icon_ins7:Lcom/aio/downloader/views/RoundImageView;

.field private iv_icon_ins8:Lcom/aio/downloader/views/RoundImageView;

.field private iv_icon_ins9:Lcom/aio/downloader/views/RoundImageView;

.field private rl_battery_ok:Landroid/widget/RelativeLayout;

.field private size:I

.field private tv_9apps:Landroid/widget/TextView;

.field private tv_battery_low_appname:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;ILandroid/view/View$OnClickListener;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "customdialog"    # I
    .param p3, "itemsOnClick"    # Landroid/view/View$OnClickListener;

    .prologue
    .line 46
    invoke-direct {p0, p1, p2}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 37
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    .line 47
    iput-object p1, p0, Lcom/aio/downloader/dialog/Batterylow;->ctx:Landroid/content/Context;

    .line 48
    iput-object p3, p0, Lcom/aio/downloader/dialog/Batterylow;->itemsOnClick:Landroid/view/View$OnClickListener;

    .line 49
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 12
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v11, 0x3

    const/4 v10, 0x2

    const/4 v9, 0x1

    const/4 v8, 0x0

    const/16 v7, 0x8

    .line 54
    invoke-super {p0, p1}, Landroid/app/Dialog;->onCreate(Landroid/os/Bundle;)V

    .line 55
    const v4, 0x7f030020

    invoke-virtual {p0, v4}, Lcom/aio/downloader/dialog/Batterylow;->setContentView(I)V

    .line 56
    const v4, 0x7f070123

    invoke-virtual {p0, v4}, Lcom/aio/downloader/dialog/Batterylow;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    iput-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->tv_battery_low_appname:Landroid/widget/TextView;

    .line 57
    const v4, 0x7f070124

    invoke-virtual {p0, v4}, Lcom/aio/downloader/dialog/Batterylow;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    iput-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->tv_9apps:Landroid/widget/TextView;

    .line 58
    const v4, 0x7f070125

    invoke-virtual {p0, v4}, Lcom/aio/downloader/dialog/Batterylow;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/views/RoundImageView;

    iput-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins1:Lcom/aio/downloader/views/RoundImageView;

    .line 59
    const v4, 0x7f070126

    invoke-virtual {p0, v4}, Lcom/aio/downloader/dialog/Batterylow;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/views/RoundImageView;

    iput-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins2:Lcom/aio/downloader/views/RoundImageView;

    .line 60
    const v4, 0x7f070127

    invoke-virtual {p0, v4}, Lcom/aio/downloader/dialog/Batterylow;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/views/RoundImageView;

    iput-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins3:Lcom/aio/downloader/views/RoundImageView;

    .line 61
    const v4, 0x7f070128

    invoke-virtual {p0, v4}, Lcom/aio/downloader/dialog/Batterylow;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/views/RoundImageView;

    iput-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins4:Lcom/aio/downloader/views/RoundImageView;

    .line 62
    const v4, 0x7f070129

    invoke-virtual {p0, v4}, Lcom/aio/downloader/dialog/Batterylow;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/views/RoundImageView;

    iput-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins5:Lcom/aio/downloader/views/RoundImageView;

    .line 63
    const v4, 0x7f07012a

    invoke-virtual {p0, v4}, Lcom/aio/downloader/dialog/Batterylow;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/views/RoundImageView;

    iput-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins6:Lcom/aio/downloader/views/RoundImageView;

    .line 64
    const v4, 0x7f07012b

    invoke-virtual {p0, v4}, Lcom/aio/downloader/dialog/Batterylow;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/views/RoundImageView;

    iput-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins7:Lcom/aio/downloader/views/RoundImageView;

    .line 65
    const v4, 0x7f07012c

    invoke-virtual {p0, v4}, Lcom/aio/downloader/dialog/Batterylow;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/views/RoundImageView;

    iput-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins8:Lcom/aio/downloader/views/RoundImageView;

    .line 66
    const v4, 0x7f07012d

    invoke-virtual {p0, v4}, Lcom/aio/downloader/dialog/Batterylow;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/views/RoundImageView;

    iput-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins9:Lcom/aio/downloader/views/RoundImageView;

    .line 67
    const v4, 0x7f07012e

    invoke-virtual {p0, v4}, Lcom/aio/downloader/dialog/Batterylow;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/views/RoundImageView;

    iput-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins10:Lcom/aio/downloader/views/RoundImageView;

    .line 68
    const v4, 0x7f07012f

    invoke-virtual {p0, v4}, Lcom/aio/downloader/dialog/Batterylow;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/Button;

    iput-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->batterycancel:Landroid/widget/Button;

    .line 69
    const v4, 0x7f070130

    invoke-virtual {p0, v4}, Lcom/aio/downloader/dialog/Batterylow;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/RelativeLayout;

    iput-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->rl_battery_ok:Landroid/widget/RelativeLayout;

    .line 70
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->batterycancel:Landroid/widget/Button;

    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->itemsOnClick:Landroid/view/View$OnClickListener;

    invoke-virtual {v4, v5}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 71
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->rl_battery_ok:Landroid/widget/RelativeLayout;

    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->itemsOnClick:Landroid/view/View$OnClickListener;

    invoke-virtual {v4, v5}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 72
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->tv_battery_low_appname:Landroid/widget/TextView;

    .line 74
    const-string v5, "Fix to save <font color=\'#ff0000\'>50%</font> power"

    invoke-static {v5}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v5

    .line 73
    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 76
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->clear()V

    .line 77
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->ctx:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    .line 79
    .local v3, "pm":Landroid/content/pm/PackageManager;
    const/16 v4, 0x2000

    invoke-virtual {v3, v4}, Landroid/content/pm/PackageManager;->getInstalledApplications(I)Ljava/util/List;

    move-result-object v0

    .line 80
    .local v0, "ai":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ApplicationInfo;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v4

    if-lt v1, v4, :cond_0

    .line 92
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    const/16 v5, 0x46

    if-lt v4, v5, :cond_2

    .line 93
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    add-int/lit8 v4, v4, -0x3a

    iput v4, p0, Lcom/aio/downloader/dialog/Batterylow;->size:I

    .line 107
    :goto_1
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->tv_9apps:Landroid/widget/TextView;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "<font color=\'#ff0000\'>"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v6, p0, Lcom/aio/downloader/dialog/Batterylow;->size:I

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    .line 108
    const-string v6, "</font> Apps are killing your battery!"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 107
    invoke-static {v5}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 109
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    const/16 v5, 0xa

    if-lt v4, v5, :cond_8

    .line 110
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins1:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 111
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins2:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 112
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins3:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 113
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins4:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v11}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 114
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins5:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    const/4 v6, 0x4

    invoke-interface {v4, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 115
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins6:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    const/4 v6, 0x5

    invoke-interface {v4, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 116
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins7:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    const/4 v6, 0x6

    invoke-interface {v4, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 117
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins8:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    const/4 v6, 0x7

    invoke-interface {v4, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 118
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins9:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 119
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins10:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    const/16 v6, 0x9

    invoke-interface {v4, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 232
    :goto_2
    return-void

    .line 81
    :cond_0
    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/pm/ApplicationInfo;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/pm/ApplicationInfo;

    iget v4, v4, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/lit8 v4, v4, 0x1

    if-nez v4, :cond_1

    .line 82
    new-instance v2, Lcom/aio/downloader/model/Info;

    invoke-direct {v2}, Lcom/aio/downloader/model/Info;-><init>()V

    .line 83
    .local v2, "info":Lcom/aio/downloader/model/Info;
    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/pm/ApplicationInfo;

    invoke-virtual {v3, v4}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v4

    invoke-interface {v4}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/aio/downloader/model/Info;->setName(Ljava/lang/String;)V

    .line 84
    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/pm/ApplicationInfo;

    invoke-virtual {v4, v3}, Landroid/content/pm/ApplicationInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/aio/downloader/model/Info;->setIcon(Landroid/graphics/drawable/Drawable;)V

    .line 85
    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/pm/ApplicationInfo;

    iget-object v4, v4, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v2, v4}, Lcom/aio/downloader/model/Info;->setPackagename(Ljava/lang/String;)V

    .line 86
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 87
    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/pm/ApplicationInfo;

    iget-object v4, v4, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    const-string v5, "com.allinone.free"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/pm/ApplicationInfo;

    iget-object v4, v4, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    const-string v5, "com.aio.downloader"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 88
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 80
    .end local v2    # "info":Lcom/aio/downloader/model/Info;
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_0

    .line 94
    :cond_2
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    const/16 v5, 0x3c

    if-le v4, v5, :cond_3

    .line 95
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    add-int/lit8 v4, v4, -0x30

    iput v4, p0, Lcom/aio/downloader/dialog/Batterylow;->size:I

    goto/16 :goto_1

    .line 96
    :cond_3
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    const/16 v5, 0x32

    if-le v4, v5, :cond_4

    .line 97
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    add-int/lit8 v4, v4, -0x26

    iput v4, p0, Lcom/aio/downloader/dialog/Batterylow;->size:I

    goto/16 :goto_1

    .line 98
    :cond_4
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    const/16 v5, 0x28

    if-le v4, v5, :cond_5

    .line 99
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    add-int/lit8 v4, v4, -0x1c

    iput v4, p0, Lcom/aio/downloader/dialog/Batterylow;->size:I

    goto/16 :goto_1

    .line 100
    :cond_5
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    const/16 v5, 0x1e

    if-le v4, v5, :cond_6

    .line 101
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    add-int/lit8 v4, v4, -0x12

    iput v4, p0, Lcom/aio/downloader/dialog/Batterylow;->size:I

    goto/16 :goto_1

    .line 102
    :cond_6
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    const/16 v5, 0x14

    if-le v4, v5, :cond_7

    .line 103
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    add-int/lit8 v4, v4, -0x8

    iput v4, p0, Lcom/aio/downloader/dialog/Batterylow;->size:I

    goto/16 :goto_1

    .line 105
    :cond_7
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    iput v4, p0, Lcom/aio/downloader/dialog/Batterylow;->size:I

    goto/16 :goto_1

    .line 120
    :cond_8
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    const/16 v5, 0x9

    if-ne v4, v5, :cond_9

    .line 121
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins1:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 122
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins2:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 123
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins3:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 124
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins4:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v11}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 125
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins5:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    const/4 v6, 0x4

    invoke-interface {v4, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 126
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins6:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    const/4 v6, 0x5

    invoke-interface {v4, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 127
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins7:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    const/4 v6, 0x6

    invoke-interface {v4, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 128
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins8:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    const/4 v6, 0x7

    invoke-interface {v4, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 129
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins9:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 130
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins10:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    goto/16 :goto_2

    .line 131
    :cond_9
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    if-ne v4, v7, :cond_a

    .line 132
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins1:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 133
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins2:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 134
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins3:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 135
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins4:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v11}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 136
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins5:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    const/4 v6, 0x4

    invoke-interface {v4, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 137
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins6:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    const/4 v6, 0x5

    invoke-interface {v4, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 138
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins7:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    const/4 v6, 0x6

    invoke-interface {v4, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 139
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins8:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    const/4 v6, 0x7

    invoke-interface {v4, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 140
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins9:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 141
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins10:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    goto/16 :goto_2

    .line 142
    :cond_a
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    const/4 v5, 0x7

    if-ne v4, v5, :cond_b

    .line 143
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins1:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 144
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins2:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 145
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins3:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 146
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins4:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v11}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 147
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins5:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    const/4 v6, 0x4

    invoke-interface {v4, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 148
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins6:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    const/4 v6, 0x5

    invoke-interface {v4, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 149
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins7:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    const/4 v6, 0x6

    invoke-interface {v4, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 150
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins8:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 151
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins9:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 152
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins10:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    goto/16 :goto_2

    .line 153
    :cond_b
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    const/4 v5, 0x6

    if-ne v4, v5, :cond_c

    .line 154
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins1:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 155
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins2:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 156
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins3:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 157
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins4:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v11}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 158
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins5:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    const/4 v6, 0x4

    invoke-interface {v4, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 159
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins6:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    const/4 v6, 0x5

    invoke-interface {v4, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 160
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins7:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 161
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins8:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 162
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins9:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 163
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins10:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    goto/16 :goto_2

    .line 164
    :cond_c
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    const/4 v5, 0x5

    if-ne v4, v5, :cond_d

    .line 165
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins1:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 166
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins2:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 167
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins3:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 168
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins4:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v11}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 169
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins5:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    const/4 v6, 0x4

    invoke-interface {v4, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 170
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins6:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 171
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins7:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 172
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins8:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 173
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins9:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 174
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins10:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    goto/16 :goto_2

    .line 175
    :cond_d
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    const/4 v5, 0x4

    if-ne v4, v5, :cond_e

    .line 176
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins1:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 177
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins2:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 178
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins3:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 179
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins4:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v11}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 180
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins5:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 181
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins6:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 182
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins7:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 183
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins8:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 184
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins9:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 185
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins10:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    goto/16 :goto_2

    .line 186
    :cond_e
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    if-ne v4, v11, :cond_f

    .line 187
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins1:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 188
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins2:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 189
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins3:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 190
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins4:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 191
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins5:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 192
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins6:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 193
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins7:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 194
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins8:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 195
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins9:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 196
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins10:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    goto/16 :goto_2

    .line 197
    :cond_f
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    if-ne v4, v10, :cond_10

    .line 198
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins1:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 199
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins2:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 200
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins3:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 201
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins4:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 202
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins5:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 203
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins6:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 204
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins7:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 205
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins8:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 206
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins9:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 207
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins10:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    goto/16 :goto_2

    .line 208
    :cond_10
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    if-ne v4, v9, :cond_11

    .line 209
    iget-object v5, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins1:Lcom/aio/downloader/views/RoundImageView;

    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->infos:Ljava/util/List;

    invoke-interface {v4, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/model/Info;

    invoke-virtual {v4}, Lcom/aio/downloader/model/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v5, v4}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 210
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins2:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 211
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins3:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 212
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins4:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 213
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins5:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 214
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins6:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 215
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins7:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 216
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins8:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 217
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins9:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 218
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins10:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    goto/16 :goto_2

    .line 220
    :cond_11
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins1:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 221
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins2:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 222
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins3:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 223
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins4:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 224
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins5:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 225
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins6:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 226
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins7:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 227
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins8:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 228
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins9:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    .line 229
    iget-object v4, p0, Lcom/aio/downloader/dialog/Batterylow;->iv_icon_ins10:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v4, v7}, Lcom/aio/downloader/views/RoundImageView;->setVisibility(I)V

    goto/16 :goto_2
.end method

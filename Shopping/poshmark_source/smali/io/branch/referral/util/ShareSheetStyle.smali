.class public Lio/branch/referral/util/ShareSheetStyle;
.super Ljava/lang/Object;
.source "ShareSheetStyle.java"


# instance fields
.field final context_:Landroid/content/Context;

.field private copyURlText_:Ljava/lang/String;

.field private copyUrlIcon_:Landroid/graphics/drawable/Drawable;

.field private defaultURL_:Ljava/lang/String;

.field private final messageBody_:Ljava/lang/String;

.field private final messageTitle_:Ljava/lang/String;

.field private moreOptionIcon_:Landroid/graphics/drawable/Drawable;

.field private moreOptionText_:Ljava/lang/String;

.field private final preferredOptions_:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lio/branch/referral/SharingHelper$SHARE_WITH;",
            ">;"
        }
    .end annotation
.end field

.field private urlCopiedMessage_:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p2, "messageTitle"    # Ljava/lang/String;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p3, "messageBody"    # Ljava/lang/String;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .prologue
    const/4 v1, 0x0

    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    iput-object p1, p0, Lio/branch/referral/util/ShareSheetStyle;->context_:Landroid/content/Context;

    .line 42
    iput-object v1, p0, Lio/branch/referral/util/ShareSheetStyle;->moreOptionIcon_:Landroid/graphics/drawable/Drawable;

    .line 43
    iput-object v1, p0, Lio/branch/referral/util/ShareSheetStyle;->moreOptionText_:Ljava/lang/String;

    .line 45
    iput-object v1, p0, Lio/branch/referral/util/ShareSheetStyle;->copyUrlIcon_:Landroid/graphics/drawable/Drawable;

    .line 46
    iput-object v1, p0, Lio/branch/referral/util/ShareSheetStyle;->copyURlText_:Ljava/lang/String;

    .line 47
    iput-object v1, p0, Lio/branch/referral/util/ShareSheetStyle;->urlCopiedMessage_:Ljava/lang/String;

    .line 49
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lio/branch/referral/util/ShareSheetStyle;->preferredOptions_:Ljava/util/ArrayList;

    .line 50
    iput-object v1, p0, Lio/branch/referral/util/ShareSheetStyle;->defaultURL_:Ljava/lang/String;

    .line 52
    iput-object p2, p0, Lio/branch/referral/util/ShareSheetStyle;->messageTitle_:Ljava/lang/String;

    .line 53
    iput-object p3, p0, Lio/branch/referral/util/ShareSheetStyle;->messageBody_:Ljava/lang/String;

    .line 54
    return-void
.end method

.method private getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p2, "drawableID"    # I
        .annotation build Landroid/support/annotation/DrawableRes;
        .end annotation
    .end param

    .prologue
    .line 178
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-lt v0, v1, :cond_0

    .line 179
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {p1}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v1

    invoke-virtual {v0, p2, v1}, Landroid/content/res/Resources;->getDrawable(ILandroid/content/res/Resources$Theme;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 182
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method public addPreferredSharingOption(Lio/branch/referral/SharingHelper$SHARE_WITH;)Lio/branch/referral/util/ShareSheetStyle;
    .locals 1
    .param p1, "preferredOption"    # Lio/branch/referral/SharingHelper$SHARE_WITH;

    .prologue
    .line 137
    iget-object v0, p0, Lio/branch/referral/util/ShareSheetStyle;->preferredOptions_:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 138
    return-object p0
.end method

.method public getCopyURlText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Lio/branch/referral/util/ShareSheetStyle;->copyURlText_:Ljava/lang/String;

    return-object v0
.end method

.method public getCopyUrlIcon()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 146
    iget-object v0, p0, Lio/branch/referral/util/ShareSheetStyle;->copyUrlIcon_:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public getDefaultURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 166
    iget-object v0, p0, Lio/branch/referral/util/ShareSheetStyle;->defaultURL_:Ljava/lang/String;

    return-object v0
.end method

.method public getMessageBody()Ljava/lang/String;
    .locals 1

    .prologue
    .line 154
    iget-object v0, p0, Lio/branch/referral/util/ShareSheetStyle;->messageBody_:Ljava/lang/String;

    return-object v0
.end method

.method public getMessageTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 158
    iget-object v0, p0, Lio/branch/referral/util/ShareSheetStyle;->messageTitle_:Ljava/lang/String;

    return-object v0
.end method

.method public getMoreOptionIcon()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 150
    iget-object v0, p0, Lio/branch/referral/util/ShareSheetStyle;->moreOptionIcon_:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public getMoreOptionText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 170
    iget-object v0, p0, Lio/branch/referral/util/ShareSheetStyle;->moreOptionText_:Ljava/lang/String;

    return-object v0
.end method

.method public getPreferredOptions()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lio/branch/referral/SharingHelper$SHARE_WITH;",
            ">;"
        }
    .end annotation

    .prologue
    .line 142
    iget-object v0, p0, Lio/branch/referral/util/ShareSheetStyle;->preferredOptions_:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getUrlCopiedMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lio/branch/referral/util/ShareSheetStyle;->urlCopiedMessage_:Ljava/lang/String;

    return-object v0
.end method

.method public setCopyUrlStyle(III)Lio/branch/referral/util/ShareSheetStyle;
    .locals 1
    .param p1, "drawableIconID"    # I
        .annotation build Landroid/support/annotation/DrawableRes;
        .end annotation
    .end param
    .param p2, "stringLabelID"    # I
        .annotation build Landroid/support/annotation/StringRes;
        .end annotation
    .end param
    .param p3, "stringMessageID"    # I
        .annotation build Landroid/support/annotation/StringRes;
        .end annotation
    .end param

    .prologue
    .line 121
    iget-object v0, p0, Lio/branch/referral/util/ShareSheetStyle;->context_:Landroid/content/Context;

    invoke-direct {p0, v0, p1}, Lio/branch/referral/util/ShareSheetStyle;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lio/branch/referral/util/ShareSheetStyle;->copyUrlIcon_:Landroid/graphics/drawable/Drawable;

    .line 122
    iget-object v0, p0, Lio/branch/referral/util/ShareSheetStyle;->context_:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lio/branch/referral/util/ShareSheetStyle;->copyURlText_:Ljava/lang/String;

    .line 123
    iget-object v0, p0, Lio/branch/referral/util/ShareSheetStyle;->context_:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lio/branch/referral/util/ShareSheetStyle;->urlCopiedMessage_:Ljava/lang/String;

    .line 124
    return-object p0
.end method

.method public setCopyUrlStyle(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;)Lio/branch/referral/util/ShareSheetStyle;
    .locals 0
    .param p1, "icon"    # Landroid/graphics/drawable/Drawable;
    .param p2, "label"    # Ljava/lang/String;
    .param p3, "message"    # Ljava/lang/String;

    .prologue
    .line 106
    iput-object p1, p0, Lio/branch/referral/util/ShareSheetStyle;->copyUrlIcon_:Landroid/graphics/drawable/Drawable;

    .line 107
    iput-object p2, p0, Lio/branch/referral/util/ShareSheetStyle;->copyURlText_:Ljava/lang/String;

    .line 108
    iput-object p3, p0, Lio/branch/referral/util/ShareSheetStyle;->urlCopiedMessage_:Ljava/lang/String;

    .line 109
    return-object p0
.end method

.method public setDefaultURL(Ljava/lang/String;)Lio/branch/referral/util/ShareSheetStyle;
    .locals 0
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 63
    iput-object p1, p0, Lio/branch/referral/util/ShareSheetStyle;->defaultURL_:Ljava/lang/String;

    .line 64
    return-object p0
.end method

.method public setMoreOptionStyle(II)Lio/branch/referral/util/ShareSheetStyle;
    .locals 1
    .param p1, "drawableIconID"    # I
        .annotation build Landroid/support/annotation/DrawableRes;
        .end annotation
    .end param
    .param p2, "stringLabelID"    # I
        .annotation build Landroid/support/annotation/StringRes;
        .end annotation
    .end param

    .prologue
    .line 90
    iget-object v0, p0, Lio/branch/referral/util/ShareSheetStyle;->context_:Landroid/content/Context;

    invoke-direct {p0, v0, p1}, Lio/branch/referral/util/ShareSheetStyle;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lio/branch/referral/util/ShareSheetStyle;->moreOptionIcon_:Landroid/graphics/drawable/Drawable;

    .line 91
    iget-object v0, p0, Lio/branch/referral/util/ShareSheetStyle;->context_:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lio/branch/referral/util/ShareSheetStyle;->moreOptionText_:Ljava/lang/String;

    .line 93
    return-object p0
.end method

.method public setMoreOptionStyle(Landroid/graphics/drawable/Drawable;Ljava/lang/String;)Lio/branch/referral/util/ShareSheetStyle;
    .locals 0
    .param p1, "icon"    # Landroid/graphics/drawable/Drawable;
    .param p2, "label"    # Ljava/lang/String;

    .prologue
    .line 76
    iput-object p1, p0, Lio/branch/referral/util/ShareSheetStyle;->moreOptionIcon_:Landroid/graphics/drawable/Drawable;

    .line 77
    iput-object p2, p0, Lio/branch/referral/util/ShareSheetStyle;->moreOptionText_:Ljava/lang/String;

    .line 78
    return-object p0
.end method

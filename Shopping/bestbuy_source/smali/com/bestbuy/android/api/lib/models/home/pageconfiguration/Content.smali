.class public Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Content;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private VisualPageTitle:Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/VisualPageTitle;

.field private bodyCopy:Ljava/lang/String;

.field private disclaimer:Ljava/lang/String;

.field private disclaimerCallToActionLinkTo:Ljava/lang/String;

.field private disclaimerCallToActionText:Ljava/lang/String;

.field private headline:Ljava/lang/String;

.field private name:Ljava/lang/String;

.field private permission:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getBodyCopy()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Content;->bodyCopy:Ljava/lang/String;

    return-object v0
.end method

.method public getDisclaimer()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Content;->disclaimer:Ljava/lang/String;

    return-object v0
.end method

.method public getDisclaimerCallToActionLinkTo()Ljava/lang/String;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Content;->disclaimerCallToActionLinkTo:Ljava/lang/String;

    return-object v0
.end method

.method public getDisclaimerCallToActionText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Content;->disclaimerCallToActionText:Ljava/lang/String;

    return-object v0
.end method

.method public getHeadline()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Content;->headline:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Content;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getPermission()Ljava/lang/String;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Content;->permission:Ljava/lang/String;

    return-object v0
.end method

.method public getVisualPageTitle()Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/VisualPageTitle;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Content;->VisualPageTitle:Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/VisualPageTitle;

    return-object v0
.end method

.method public setBodyCopy(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 87
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Content;->bodyCopy:Ljava/lang/String;

    .line 88
    return-void
.end method

.method public setDisclaimer(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 93
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Content;->disclaimer:Ljava/lang/String;

    .line 94
    return-void
.end method

.method public setDisclaimerCallToActionLinkTo(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 111
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Content;->disclaimerCallToActionLinkTo:Ljava/lang/String;

    .line 112
    return-void
.end method

.method public setDisclaimerCallToActionText(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 81
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Content;->disclaimerCallToActionText:Ljava/lang/String;

    .line 82
    return-void
.end method

.method public setHeadline(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 75
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Content;->headline:Ljava/lang/String;

    .line 76
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 99
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Content;->name:Ljava/lang/String;

    .line 100
    return-void
.end method

.method public setPermission(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 105
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Content;->permission:Ljava/lang/String;

    .line 106
    return-void
.end method

.method public setVisualPageTitle(Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/VisualPageTitle;)V
    .locals 0

    .prologue
    .line 117
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Content;->VisualPageTitle:Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/VisualPageTitle;

    .line 118
    return-void
.end method

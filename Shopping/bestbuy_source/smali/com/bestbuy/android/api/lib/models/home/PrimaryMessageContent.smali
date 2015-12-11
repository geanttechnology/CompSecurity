.class public Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = -0x739950a23ced9db5L


# instance fields
.field private PM:Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContentPM;

.field private bodyCopy:Ljava/lang/String;

.field private callToActionButton:Ljava/lang/String;

.field private callToActionText:Ljava/lang/String;

.field private categoryCode:Ljava/lang/String;

.field private disclaimer:Ljava/lang/String;

.field private eventCode:Ljava/lang/String;

.field private headline:Ljava/lang/String;

.field private landingPageHREF:Ljava/lang/String;

.field private name:Ljava/lang/String;

.field private pageConfigHREF:Ljava/lang/String;

.field private subhead:Ljava/lang/String;


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
    .line 174
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;->bodyCopy:Ljava/lang/String;

    return-object v0
.end method

.method public getCallToActionButton()Ljava/lang/String;
    .locals 1

    .prologue
    .line 118
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;->callToActionButton:Ljava/lang/String;

    return-object v0
.end method

.method public getCallToActionText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 132
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;->callToActionText:Ljava/lang/String;

    return-object v0
.end method

.method public getCategoryCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;->categoryCode:Ljava/lang/String;

    return-object v0
.end method

.method public getDisclaimer()Ljava/lang/String;
    .locals 1

    .prologue
    .line 160
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;->disclaimer:Ljava/lang/String;

    return-object v0
.end method

.method public getEventCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;->eventCode:Ljava/lang/String;

    return-object v0
.end method

.method public getHeadline()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;->headline:Ljava/lang/String;

    return-object v0
.end method

.method public getLandingPageHREF()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;->landingPageHREF:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getPM()Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContentPM;
    .locals 1

    .prologue
    .line 146
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;->PM:Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContentPM;

    return-object v0
.end method

.method public getPageConfigHREF()Ljava/lang/String;
    .locals 1

    .prologue
    .line 188
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;->pageConfigHREF:Ljava/lang/String;

    return-object v0
.end method

.method public getSubhead()Ljava/lang/String;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;->subhead:Ljava/lang/String;

    return-object v0
.end method

.method public setBodyCopy(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 181
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;->bodyCopy:Ljava/lang/String;

    .line 182
    return-void
.end method

.method public setCallToActionButton(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 125
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;->callToActionButton:Ljava/lang/String;

    .line 126
    return-void
.end method

.method public setCallToActionText(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 139
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;->callToActionText:Ljava/lang/String;

    .line 140
    return-void
.end method

.method public setCategoryCode(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 111
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;->categoryCode:Ljava/lang/String;

    .line 112
    return-void
.end method

.method public setDisclaimer(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 167
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;->disclaimer:Ljava/lang/String;

    .line 168
    return-void
.end method

.method public setEventCode(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 83
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;->eventCode:Ljava/lang/String;

    .line 84
    return-void
.end method

.method public setHeadline(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 41
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;->headline:Ljava/lang/String;

    .line 42
    return-void
.end method

.method public setLandingPageHREF(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 55
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;->landingPageHREF:Ljava/lang/String;

    .line 56
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;->name:Ljava/lang/String;

    .line 70
    return-void
.end method

.method public setPM(Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContentPM;)V
    .locals 0

    .prologue
    .line 153
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;->PM:Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContentPM;

    .line 154
    return-void
.end method

.method public setPageConfigHREF(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 195
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;->pageConfigHREF:Ljava/lang/String;

    .line 196
    return-void
.end method

.method public setSubhead(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 97
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;->subhead:Ljava/lang/String;

    .line 98
    return-void
.end method

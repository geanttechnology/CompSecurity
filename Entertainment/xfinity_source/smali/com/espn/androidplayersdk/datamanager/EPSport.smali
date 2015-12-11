.class public Lcom/espn/androidplayersdk/datamanager/EPSport;
.super Ljava/lang/Object;
.source "EPSport.java"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x3809c0b4bfa49d0cL


# instance fields
.field private ShortName:Ljava/lang/String;

.field private abbre:Ljava/lang/String;

.field private id:Ljava/lang/String;

.field private leagueId:Ljava/lang/String;

.field private listingLink:Ljava/lang/String;

.field private name:Ljava/lang/String;

.field private topListingLink:Ljava/lang/String;

.field private type:Ljava/lang/String;

.field private vodLink:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "id"    # Ljava/lang/String;
    .param p3, "abbre"    # Ljava/lang/String;

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/EPSport;->name:Ljava/lang/String;

    .line 23
    iput-object p2, p0, Lcom/espn/androidplayersdk/datamanager/EPSport;->id:Ljava/lang/String;

    .line 24
    iput-object p3, p0, Lcom/espn/androidplayersdk/datamanager/EPSport;->abbre:Ljava/lang/String;

    .line 25
    return-void
.end method

.method protected constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "id"    # Ljava/lang/String;
    .param p3, "abbre"    # Ljava/lang/String;
    .param p4, "leagueId"    # Ljava/lang/String;
    .param p5, "shortName"    # Ljava/lang/String;
    .param p6, "type"    # Ljava/lang/String;
    .param p7, "vodLink"    # Ljava/lang/String;
    .param p8, "listingUrl"    # Ljava/lang/String;
    .param p9, "topListingLink"    # Ljava/lang/String;

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/EPSport;->name:Ljava/lang/String;

    .line 29
    iput-object p2, p0, Lcom/espn/androidplayersdk/datamanager/EPSport;->id:Ljava/lang/String;

    .line 30
    iput-object p3, p0, Lcom/espn/androidplayersdk/datamanager/EPSport;->abbre:Ljava/lang/String;

    .line 31
    iput-object p4, p0, Lcom/espn/androidplayersdk/datamanager/EPSport;->leagueId:Ljava/lang/String;

    .line 32
    iput-object p5, p0, Lcom/espn/androidplayersdk/datamanager/EPSport;->ShortName:Ljava/lang/String;

    .line 33
    iput-object p6, p0, Lcom/espn/androidplayersdk/datamanager/EPSport;->type:Ljava/lang/String;

    .line 34
    iput-object p7, p0, Lcom/espn/androidplayersdk/datamanager/EPSport;->vodLink:Ljava/lang/String;

    .line 35
    iput-object p8, p0, Lcom/espn/androidplayersdk/datamanager/EPSport;->listingLink:Ljava/lang/String;

    .line 36
    iput-object p9, p0, Lcom/espn/androidplayersdk/datamanager/EPSport;->topListingLink:Ljava/lang/String;

    .line 37
    return-void
.end method


# virtual methods
.method public getAbbreviation()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPSport;->abbre:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPSport;->id:Ljava/lang/String;

    return-object v0
.end method

.method protected getLeagueId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPSport;->leagueId:Ljava/lang/String;

    return-object v0
.end method

.method protected getListingLink()Ljava/lang/String;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPSport;->listingLink:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPSport;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getShortName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPSport;->ShortName:Ljava/lang/String;

    return-object v0
.end method

.method protected getTopListingLink()Ljava/lang/String;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPSport;->topListingLink:Ljava/lang/String;

    return-object v0
.end method

.method protected getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPSport;->type:Ljava/lang/String;

    return-object v0
.end method

.method protected getVodLink()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPSport;->vodLink:Ljava/lang/String;

    return-object v0
.end method

.class public abstract enum Lcom/amazon/mobile/mash/appcontext/Capability;
.super Ljava/lang/Enum;
.source "Capability.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mobile/mash/appcontext/Capability;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mobile/mash/appcontext/Capability;

.field public static final enum AIV_PLAYBACK:Lcom/amazon/mobile/mash/appcontext/Capability;

.field public static final enum APPSTORE:Lcom/amazon/mobile/mash/appcontext/Capability;

.field public static final enum APP_NAV_MENU:Lcom/amazon/mobile/mash/appcontext/Capability;

.field public static final enum ENFORCE_PARENTAL_CONTROLS:Lcom/amazon/mobile/mash/appcontext/Capability;

.field public static final enum SHOW_ADS_BROWSER:Lcom/amazon/mobile/mash/appcontext/Capability;

.field public static final enum SHOW_AMAZON_POINTS:Lcom/amazon/mobile/mash/appcontext/Capability;

.field public static final enum SHOW_CARD_SCANNER_CREDIT:Lcom/amazon/mobile/mash/appcontext/Capability;

.field public static final enum SHOW_CONTACT_PICKER:Lcom/amazon/mobile/mash/appcontext/Capability;

.field public static final enum SHOW_DELIVERY_DESTINATION_PICKER:Lcom/amazon/mobile/mash/appcontext/Capability;

.field public static final enum SHOW_NOTIFICATION_SETTINGS:Lcom/amazon/mobile/mash/appcontext/Capability;

.field public static final enum SMILE:Lcom/amazon/mobile/mash/appcontext/Capability;


# instance fields
.field private mCapabilityId:I

.field private mIsAvailable:Ljava/lang/Boolean;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 15
    new-instance v0, Lcom/amazon/mobile/mash/appcontext/Capability$1;

    const-string/jumbo v1, "SHOW_CONTACT_PICKER"

    invoke-direct {v0, v1, v4, v4}, Lcom/amazon/mobile/mash/appcontext/Capability$1;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mobile/mash/appcontext/Capability;->SHOW_CONTACT_PICKER:Lcom/amazon/mobile/mash/appcontext/Capability;

    .line 25
    new-instance v0, Lcom/amazon/mobile/mash/appcontext/Capability$2;

    const-string/jumbo v1, "SHOW_AMAZON_POINTS"

    invoke-direct {v0, v1, v5, v5}, Lcom/amazon/mobile/mash/appcontext/Capability$2;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mobile/mash/appcontext/Capability;->SHOW_AMAZON_POINTS:Lcom/amazon/mobile/mash/appcontext/Capability;

    .line 35
    new-instance v0, Lcom/amazon/mobile/mash/appcontext/Capability$3;

    const-string/jumbo v1, "SHOW_DELIVERY_DESTINATION_PICKER"

    invoke-direct {v0, v1, v6, v6}, Lcom/amazon/mobile/mash/appcontext/Capability$3;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mobile/mash/appcontext/Capability;->SHOW_DELIVERY_DESTINATION_PICKER:Lcom/amazon/mobile/mash/appcontext/Capability;

    .line 45
    new-instance v0, Lcom/amazon/mobile/mash/appcontext/Capability$4;

    const-string/jumbo v1, "APP_NAV_MENU"

    invoke-direct {v0, v1, v7, v7}, Lcom/amazon/mobile/mash/appcontext/Capability$4;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mobile/mash/appcontext/Capability;->APP_NAV_MENU:Lcom/amazon/mobile/mash/appcontext/Capability;

    .line 55
    new-instance v0, Lcom/amazon/mobile/mash/appcontext/Capability$5;

    const-string/jumbo v1, "SHOW_NOTIFICATION_SETTINGS"

    invoke-direct {v0, v1, v8, v8}, Lcom/amazon/mobile/mash/appcontext/Capability$5;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mobile/mash/appcontext/Capability;->SHOW_NOTIFICATION_SETTINGS:Lcom/amazon/mobile/mash/appcontext/Capability;

    .line 65
    new-instance v0, Lcom/amazon/mobile/mash/appcontext/Capability$6;

    const-string/jumbo v1, "ENFORCE_PARENTAL_CONTROLS"

    const/4 v2, 0x5

    const/4 v3, 0x5

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mobile/mash/appcontext/Capability$6;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mobile/mash/appcontext/Capability;->ENFORCE_PARENTAL_CONTROLS:Lcom/amazon/mobile/mash/appcontext/Capability;

    .line 74
    new-instance v0, Lcom/amazon/mobile/mash/appcontext/Capability$7;

    const-string/jumbo v1, "AIV_PLAYBACK"

    const/4 v2, 0x6

    const/4 v3, 0x6

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mobile/mash/appcontext/Capability$7;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mobile/mash/appcontext/Capability;->AIV_PLAYBACK:Lcom/amazon/mobile/mash/appcontext/Capability;

    .line 83
    new-instance v0, Lcom/amazon/mobile/mash/appcontext/Capability$8;

    const-string/jumbo v1, "SHOW_ADS_BROWSER"

    const/4 v2, 0x7

    const/4 v3, 0x7

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mobile/mash/appcontext/Capability$8;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mobile/mash/appcontext/Capability;->SHOW_ADS_BROWSER:Lcom/amazon/mobile/mash/appcontext/Capability;

    .line 92
    new-instance v0, Lcom/amazon/mobile/mash/appcontext/Capability$9;

    const-string/jumbo v1, "SHOW_CARD_SCANNER_CREDIT"

    const/16 v2, 0x8

    const/16 v3, 0x8

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mobile/mash/appcontext/Capability$9;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mobile/mash/appcontext/Capability;->SHOW_CARD_SCANNER_CREDIT:Lcom/amazon/mobile/mash/appcontext/Capability;

    .line 101
    new-instance v0, Lcom/amazon/mobile/mash/appcontext/Capability$10;

    const-string/jumbo v1, "APPSTORE"

    const/16 v2, 0x9

    const/16 v3, 0xd

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mobile/mash/appcontext/Capability$10;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mobile/mash/appcontext/Capability;->APPSTORE:Lcom/amazon/mobile/mash/appcontext/Capability;

    .line 110
    new-instance v0, Lcom/amazon/mobile/mash/appcontext/Capability$11;

    const-string/jumbo v1, "SMILE"

    const/16 v2, 0xa

    const/16 v3, 0xf

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mobile/mash/appcontext/Capability$11;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mobile/mash/appcontext/Capability;->SMILE:Lcom/amazon/mobile/mash/appcontext/Capability;

    .line 11
    const/16 v0, 0xb

    new-array v0, v0, [Lcom/amazon/mobile/mash/appcontext/Capability;

    sget-object v1, Lcom/amazon/mobile/mash/appcontext/Capability;->SHOW_CONTACT_PICKER:Lcom/amazon/mobile/mash/appcontext/Capability;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/mobile/mash/appcontext/Capability;->SHOW_AMAZON_POINTS:Lcom/amazon/mobile/mash/appcontext/Capability;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/mobile/mash/appcontext/Capability;->SHOW_DELIVERY_DESTINATION_PICKER:Lcom/amazon/mobile/mash/appcontext/Capability;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/mobile/mash/appcontext/Capability;->APP_NAV_MENU:Lcom/amazon/mobile/mash/appcontext/Capability;

    aput-object v1, v0, v7

    sget-object v1, Lcom/amazon/mobile/mash/appcontext/Capability;->SHOW_NOTIFICATION_SETTINGS:Lcom/amazon/mobile/mash/appcontext/Capability;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/mobile/mash/appcontext/Capability;->ENFORCE_PARENTAL_CONTROLS:Lcom/amazon/mobile/mash/appcontext/Capability;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/mobile/mash/appcontext/Capability;->AIV_PLAYBACK:Lcom/amazon/mobile/mash/appcontext/Capability;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/mobile/mash/appcontext/Capability;->SHOW_ADS_BROWSER:Lcom/amazon/mobile/mash/appcontext/Capability;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/mobile/mash/appcontext/Capability;->SHOW_CARD_SCANNER_CREDIT:Lcom/amazon/mobile/mash/appcontext/Capability;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/amazon/mobile/mash/appcontext/Capability;->APPSTORE:Lcom/amazon/mobile/mash/appcontext/Capability;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/amazon/mobile/mash/appcontext/Capability;->SMILE:Lcom/amazon/mobile/mash/appcontext/Capability;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/mobile/mash/appcontext/Capability;->$VALUES:[Lcom/amazon/mobile/mash/appcontext/Capability;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 1
    .param p3, "capabilityId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 124
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 118
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mobile/mash/appcontext/Capability;->mIsAvailable:Ljava/lang/Boolean;

    .line 125
    iput p3, p0, Lcom/amazon/mobile/mash/appcontext/Capability;->mCapabilityId:I

    .line 126
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;IILcom/amazon/mobile/mash/appcontext/Capability$1;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/String;
    .param p2, "x1"    # I
    .param p3, "x2"    # I
    .param p4, "x3"    # Lcom/amazon/mobile/mash/appcontext/Capability$1;

    .prologue
    .line 11
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/mobile/mash/appcontext/Capability;-><init>(Ljava/lang/String;II)V

    return-void
.end method

.method public static init(Lcom/amazon/mobile/mash/appcontext/CapabilityManager;)V
    .locals 5
    .param p0, "manager"    # Lcom/amazon/mobile/mash/appcontext/CapabilityManager;

    .prologue
    .line 169
    invoke-static {}, Lcom/amazon/mobile/mash/appcontext/Capability;->values()[Lcom/amazon/mobile/mash/appcontext/Capability;

    move-result-object v2

    .line 170
    .local v2, "capabilities":[Lcom/amazon/mobile/mash/appcontext/Capability;
    move-object v0, v2

    .local v0, "arr$":[Lcom/amazon/mobile/mash/appcontext/Capability;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v4, :cond_0

    aget-object v1, v0, v3

    .line 171
    .local v1, "c":Lcom/amazon/mobile/mash/appcontext/Capability;
    invoke-virtual {v1, p0}, Lcom/amazon/mobile/mash/appcontext/Capability;->initAvailability(Lcom/amazon/mobile/mash/appcontext/CapabilityManager;)V

    .line 170
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 173
    .end local v1    # "c":Lcom/amazon/mobile/mash/appcontext/Capability;
    :cond_0
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mobile/mash/appcontext/Capability;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 11
    const-class v0, Lcom/amazon/mobile/mash/appcontext/Capability;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mobile/mash/appcontext/Capability;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mobile/mash/appcontext/Capability;
    .locals 1

    .prologue
    .line 11
    sget-object v0, Lcom/amazon/mobile/mash/appcontext/Capability;->$VALUES:[Lcom/amazon/mobile/mash/appcontext/Capability;

    invoke-virtual {v0}, [Lcom/amazon/mobile/mash/appcontext/Capability;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mobile/mash/appcontext/Capability;

    return-object v0
.end method


# virtual methods
.method public getCapabilityId()I
    .locals 1

    .prologue
    .line 132
    iget v0, p0, Lcom/amazon/mobile/mash/appcontext/Capability;->mCapabilityId:I

    return v0
.end method

.method protected abstract initAvailability(Lcom/amazon/mobile/mash/appcontext/CapabilityManager;)V
.end method

.method public isAvailable()Z
    .locals 2

    .prologue
    .line 147
    iget-object v0, p0, Lcom/amazon/mobile/mash/appcontext/Capability;->mIsAvailable:Ljava/lang/Boolean;

    if-nez v0, :cond_0

    .line 148
    new-instance v0, Ljava/lang/RuntimeException;

    const-string/jumbo v1, "Should call Capability.init(CapabilityManager) before calling this method."

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 150
    :cond_0
    iget-object v0, p0, Lcom/amazon/mobile/mash/appcontext/Capability;->mIsAvailable:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    return v0
.end method

.method protected setIsAvailable(Z)V
    .locals 1
    .param p1, "isAvailable"    # Z

    .prologue
    .line 140
    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mobile/mash/appcontext/Capability;->mIsAvailable:Ljava/lang/Boolean;

    .line 141
    return-void
.end method

.class public abstract enum Lcom/amazon/identity/auth/device/features/Feature;
.super Ljava/lang/Enum;
.source "Feature.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/auth/device/features/Feature;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/auth/device/features/Feature;

.field public static final enum CombinedDelegatedAuthenticationAndRegistration:Lcom/amazon/identity/auth/device/features/Feature;

.field public static final enum DSNWhenNotRegistered:Lcom/amazon/identity/auth/device/features/Feature;

.field public static final enum DirectedIdSupported:Lcom/amazon/identity/auth/device/features/Feature;

.field public static final enum MovingAwayFromAM:Lcom/amazon/identity/auth/device/features/Feature;

.field public static final enum OverrideDeviceAttributes:Lcom/amazon/identity/auth/device/features/Feature;

.field public static final enum PandaRegistration:Lcom/amazon/identity/auth/device/features/Feature;

.field public static final enum RegistrationViaAuthToken:Lcom/amazon/identity/auth/device/features/Feature;

.field public static final enum SplitRegistration:Lcom/amazon/identity/auth/device/features/Feature;

.field public static final enum SplitRegistrationWithDirectedId:Lcom/amazon/identity/auth/device/features/Feature;

.field public static final enum TrustZone:Lcom/amazon/identity/auth/device/features/Feature;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 23
    new-instance v0, Lcom/amazon/identity/auth/device/features/Feature$1;

    const-string/jumbo v1, "OverrideDeviceAttributes"

    invoke-direct {v0, v1, v3}, Lcom/amazon/identity/auth/device/features/Feature$1;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/features/Feature;->OverrideDeviceAttributes:Lcom/amazon/identity/auth/device/features/Feature;

    .line 38
    new-instance v0, Lcom/amazon/identity/auth/device/features/Feature$2;

    const-string/jumbo v1, "DSNWhenNotRegistered"

    invoke-direct {v0, v1, v4}, Lcom/amazon/identity/auth/device/features/Feature$2;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/features/Feature;->DSNWhenNotRegistered:Lcom/amazon/identity/auth/device/features/Feature;

    .line 54
    new-instance v0, Lcom/amazon/identity/auth/device/features/Feature$3;

    const-string/jumbo v1, "PandaRegistration"

    invoke-direct {v0, v1, v5}, Lcom/amazon/identity/auth/device/features/Feature$3;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/features/Feature;->PandaRegistration:Lcom/amazon/identity/auth/device/features/Feature;

    .line 82
    new-instance v0, Lcom/amazon/identity/auth/device/features/Feature$4;

    const-string/jumbo v1, "SplitRegistration"

    invoke-direct {v0, v1, v6}, Lcom/amazon/identity/auth/device/features/Feature$4;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/features/Feature;->SplitRegistration:Lcom/amazon/identity/auth/device/features/Feature;

    .line 106
    new-instance v0, Lcom/amazon/identity/auth/device/features/Feature$5;

    const-string/jumbo v1, "DirectedIdSupported"

    invoke-direct {v0, v1, v7}, Lcom/amazon/identity/auth/device/features/Feature$5;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/features/Feature;->DirectedIdSupported:Lcom/amazon/identity/auth/device/features/Feature;

    .line 118
    new-instance v0, Lcom/amazon/identity/auth/device/features/Feature$6;

    const-string/jumbo v1, "SplitRegistrationWithDirectedId"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/features/Feature$6;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/features/Feature;->SplitRegistrationWithDirectedId:Lcom/amazon/identity/auth/device/features/Feature;

    .line 134
    new-instance v0, Lcom/amazon/identity/auth/device/features/Feature$7;

    const-string/jumbo v1, "RegistrationViaAuthToken"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/features/Feature$7;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/features/Feature;->RegistrationViaAuthToken:Lcom/amazon/identity/auth/device/features/Feature;

    .line 150
    new-instance v0, Lcom/amazon/identity/auth/device/features/Feature$8;

    const-string/jumbo v1, "MovingAwayFromAM"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/features/Feature$8;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/features/Feature;->MovingAwayFromAM:Lcom/amazon/identity/auth/device/features/Feature;

    .line 166
    new-instance v0, Lcom/amazon/identity/auth/device/features/Feature$9;

    const-string/jumbo v1, "TrustZone"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/features/Feature$9;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/features/Feature;->TrustZone:Lcom/amazon/identity/auth/device/features/Feature;

    .line 177
    new-instance v0, Lcom/amazon/identity/auth/device/features/Feature$10;

    const-string/jumbo v1, "CombinedDelegatedAuthenticationAndRegistration"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/features/Feature$10;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/features/Feature;->CombinedDelegatedAuthenticationAndRegistration:Lcom/amazon/identity/auth/device/features/Feature;

    .line 15
    const/16 v0, 0xa

    new-array v0, v0, [Lcom/amazon/identity/auth/device/features/Feature;

    sget-object v1, Lcom/amazon/identity/auth/device/features/Feature;->OverrideDeviceAttributes:Lcom/amazon/identity/auth/device/features/Feature;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/identity/auth/device/features/Feature;->DSNWhenNotRegistered:Lcom/amazon/identity/auth/device/features/Feature;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/identity/auth/device/features/Feature;->PandaRegistration:Lcom/amazon/identity/auth/device/features/Feature;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/identity/auth/device/features/Feature;->SplitRegistration:Lcom/amazon/identity/auth/device/features/Feature;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/identity/auth/device/features/Feature;->DirectedIdSupported:Lcom/amazon/identity/auth/device/features/Feature;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/identity/auth/device/features/Feature;->SplitRegistrationWithDirectedId:Lcom/amazon/identity/auth/device/features/Feature;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/identity/auth/device/features/Feature;->RegistrationViaAuthToken:Lcom/amazon/identity/auth/device/features/Feature;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/identity/auth/device/features/Feature;->MovingAwayFromAM:Lcom/amazon/identity/auth/device/features/Feature;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/identity/auth/device/features/Feature;->TrustZone:Lcom/amazon/identity/auth/device/features/Feature;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/amazon/identity/auth/device/features/Feature;->CombinedDelegatedAuthenticationAndRegistration:Lcom/amazon/identity/auth/device/features/Feature;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/identity/auth/device/features/Feature;->$VALUES:[Lcom/amazon/identity/auth/device/features/Feature;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 15
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;ILcom/amazon/identity/auth/device/features/Feature$1;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/String;
    .param p2, "x1"    # I
    .param p3, "x2"    # Lcom/amazon/identity/auth/device/features/Feature$1;

    .prologue
    .line 15
    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/auth/device/features/Feature;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/auth/device/features/Feature;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 15
    const-class v0, Lcom/amazon/identity/auth/device/features/Feature;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/features/Feature;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/auth/device/features/Feature;
    .locals 1

    .prologue
    .line 15
    sget-object v0, Lcom/amazon/identity/auth/device/features/Feature;->$VALUES:[Lcom/amazon/identity/auth/device/features/Feature;

    invoke-virtual {v0}, [Lcom/amazon/identity/auth/device/features/Feature;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/auth/device/features/Feature;

    return-object v0
.end method


# virtual methods
.method abstract fetchValue(Landroid/content/Context;)Z
.end method

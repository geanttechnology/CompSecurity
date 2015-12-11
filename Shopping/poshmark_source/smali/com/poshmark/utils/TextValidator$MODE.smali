.class public final enum Lcom/poshmark/utils/TextValidator$MODE;
.super Ljava/lang/Enum;
.source "TextValidator.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/TextValidator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "MODE"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/utils/TextValidator$MODE;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/utils/TextValidator$MODE;

.field public static final enum MODE_CREDITCARD:Lcom/poshmark/utils/TextValidator$MODE;

.field public static final enum MODE_DOB:Lcom/poshmark/utils/TextValidator$MODE;

.field public static final enum MODE_EMAIL:Lcom/poshmark/utils/TextValidator$MODE;

.field public static final enum MODE_PASSWORD:Lcom/poshmark/utils/TextValidator$MODE;

.field public static final enum MODE_SIMPLE:Lcom/poshmark/utils/TextValidator$MODE;

.field public static final enum MODE_SIMPLE_NO_SPACES:Lcom/poshmark/utils/TextValidator$MODE;

.field public static final enum MODE_SSN:Lcom/poshmark/utils/TextValidator$MODE;

.field public static final enum MODE_USERNAME:Lcom/poshmark/utils/TextValidator$MODE;

.field public static final enum MODE_ZIPCODE:Lcom/poshmark/utils/TextValidator$MODE;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 126
    new-instance v0, Lcom/poshmark/utils/TextValidator$MODE;

    const-string v1, "MODE_SIMPLE"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/utils/TextValidator$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/TextValidator$MODE;->MODE_SIMPLE:Lcom/poshmark/utils/TextValidator$MODE;

    .line 127
    new-instance v0, Lcom/poshmark/utils/TextValidator$MODE;

    const-string v1, "MODE_PASSWORD"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/utils/TextValidator$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/TextValidator$MODE;->MODE_PASSWORD:Lcom/poshmark/utils/TextValidator$MODE;

    .line 128
    new-instance v0, Lcom/poshmark/utils/TextValidator$MODE;

    const-string v1, "MODE_EMAIL"

    invoke-direct {v0, v1, v5}, Lcom/poshmark/utils/TextValidator$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/TextValidator$MODE;->MODE_EMAIL:Lcom/poshmark/utils/TextValidator$MODE;

    .line 129
    new-instance v0, Lcom/poshmark/utils/TextValidator$MODE;

    const-string v1, "MODE_SSN"

    invoke-direct {v0, v1, v6}, Lcom/poshmark/utils/TextValidator$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/TextValidator$MODE;->MODE_SSN:Lcom/poshmark/utils/TextValidator$MODE;

    .line 130
    new-instance v0, Lcom/poshmark/utils/TextValidator$MODE;

    const-string v1, "MODE_ZIPCODE"

    invoke-direct {v0, v1, v7}, Lcom/poshmark/utils/TextValidator$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/TextValidator$MODE;->MODE_ZIPCODE:Lcom/poshmark/utils/TextValidator$MODE;

    .line 131
    new-instance v0, Lcom/poshmark/utils/TextValidator$MODE;

    const-string v1, "MODE_DOB"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/TextValidator$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/TextValidator$MODE;->MODE_DOB:Lcom/poshmark/utils/TextValidator$MODE;

    .line 132
    new-instance v0, Lcom/poshmark/utils/TextValidator$MODE;

    const-string v1, "MODE_CREDITCARD"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/TextValidator$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/TextValidator$MODE;->MODE_CREDITCARD:Lcom/poshmark/utils/TextValidator$MODE;

    .line 133
    new-instance v0, Lcom/poshmark/utils/TextValidator$MODE;

    const-string v1, "MODE_USERNAME"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/TextValidator$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/TextValidator$MODE;->MODE_USERNAME:Lcom/poshmark/utils/TextValidator$MODE;

    .line 134
    new-instance v0, Lcom/poshmark/utils/TextValidator$MODE;

    const-string v1, "MODE_SIMPLE_NO_SPACES"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/TextValidator$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/TextValidator$MODE;->MODE_SIMPLE_NO_SPACES:Lcom/poshmark/utils/TextValidator$MODE;

    .line 125
    const/16 v0, 0x9

    new-array v0, v0, [Lcom/poshmark/utils/TextValidator$MODE;

    sget-object v1, Lcom/poshmark/utils/TextValidator$MODE;->MODE_SIMPLE:Lcom/poshmark/utils/TextValidator$MODE;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/utils/TextValidator$MODE;->MODE_PASSWORD:Lcom/poshmark/utils/TextValidator$MODE;

    aput-object v1, v0, v4

    sget-object v1, Lcom/poshmark/utils/TextValidator$MODE;->MODE_EMAIL:Lcom/poshmark/utils/TextValidator$MODE;

    aput-object v1, v0, v5

    sget-object v1, Lcom/poshmark/utils/TextValidator$MODE;->MODE_SSN:Lcom/poshmark/utils/TextValidator$MODE;

    aput-object v1, v0, v6

    sget-object v1, Lcom/poshmark/utils/TextValidator$MODE;->MODE_ZIPCODE:Lcom/poshmark/utils/TextValidator$MODE;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/poshmark/utils/TextValidator$MODE;->MODE_DOB:Lcom/poshmark/utils/TextValidator$MODE;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/poshmark/utils/TextValidator$MODE;->MODE_CREDITCARD:Lcom/poshmark/utils/TextValidator$MODE;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/poshmark/utils/TextValidator$MODE;->MODE_USERNAME:Lcom/poshmark/utils/TextValidator$MODE;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/poshmark/utils/TextValidator$MODE;->MODE_SIMPLE_NO_SPACES:Lcom/poshmark/utils/TextValidator$MODE;

    aput-object v2, v0, v1

    sput-object v0, Lcom/poshmark/utils/TextValidator$MODE;->$VALUES:[Lcom/poshmark/utils/TextValidator$MODE;

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
    .line 125
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static getMode(I)Lcom/poshmark/utils/TextValidator$MODE;
    .locals 1
    .param p0, "val"    # I

    .prologue
    .line 137
    sget-object v0, Lcom/poshmark/utils/TextValidator$MODE;->MODE_SIMPLE:Lcom/poshmark/utils/TextValidator$MODE;

    .line 138
    .local v0, "retVal":Lcom/poshmark/utils/TextValidator$MODE;
    packed-switch p0, :pswitch_data_0

    .line 176
    :goto_0
    return-object v0

    .line 140
    :pswitch_0
    sget-object v0, Lcom/poshmark/utils/TextValidator$MODE;->MODE_SIMPLE:Lcom/poshmark/utils/TextValidator$MODE;

    .line 141
    goto :goto_0

    .line 144
    :pswitch_1
    sget-object v0, Lcom/poshmark/utils/TextValidator$MODE;->MODE_PASSWORD:Lcom/poshmark/utils/TextValidator$MODE;

    .line 145
    goto :goto_0

    .line 148
    :pswitch_2
    sget-object v0, Lcom/poshmark/utils/TextValidator$MODE;->MODE_EMAIL:Lcom/poshmark/utils/TextValidator$MODE;

    .line 149
    goto :goto_0

    .line 152
    :pswitch_3
    sget-object v0, Lcom/poshmark/utils/TextValidator$MODE;->MODE_SSN:Lcom/poshmark/utils/TextValidator$MODE;

    .line 153
    goto :goto_0

    .line 156
    :pswitch_4
    sget-object v0, Lcom/poshmark/utils/TextValidator$MODE;->MODE_ZIPCODE:Lcom/poshmark/utils/TextValidator$MODE;

    .line 157
    goto :goto_0

    .line 160
    :pswitch_5
    sget-object v0, Lcom/poshmark/utils/TextValidator$MODE;->MODE_DOB:Lcom/poshmark/utils/TextValidator$MODE;

    .line 161
    goto :goto_0

    .line 164
    :pswitch_6
    sget-object v0, Lcom/poshmark/utils/TextValidator$MODE;->MODE_CREDITCARD:Lcom/poshmark/utils/TextValidator$MODE;

    .line 165
    goto :goto_0

    .line 168
    :pswitch_7
    sget-object v0, Lcom/poshmark/utils/TextValidator$MODE;->MODE_USERNAME:Lcom/poshmark/utils/TextValidator$MODE;

    .line 169
    goto :goto_0

    .line 172
    :pswitch_8
    sget-object v0, Lcom/poshmark/utils/TextValidator$MODE;->MODE_SIMPLE_NO_SPACES:Lcom/poshmark/utils/TextValidator$MODE;

    goto :goto_0

    .line 138
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
    .end packed-switch
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/utils/TextValidator$MODE;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 125
    const-class v0, Lcom/poshmark/utils/TextValidator$MODE;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/TextValidator$MODE;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/utils/TextValidator$MODE;
    .locals 1

    .prologue
    .line 125
    sget-object v0, Lcom/poshmark/utils/TextValidator$MODE;->$VALUES:[Lcom/poshmark/utils/TextValidator$MODE;

    invoke-virtual {v0}, [Lcom/poshmark/utils/TextValidator$MODE;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/utils/TextValidator$MODE;

    return-object v0
.end method

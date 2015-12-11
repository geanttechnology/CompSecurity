.class Lco/vine/android/LocaleDialog$LocaleComparator;
.super Ljava/lang/Object;
.source "LocaleDialog.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/LocaleDialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "LocaleComparator"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Ljava/util/Locale;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/LocaleDialog;


# direct methods
.method private constructor <init>(Lco/vine/android/LocaleDialog;)V
    .locals 0

    .prologue
    .line 188
    iput-object p1, p0, Lco/vine/android/LocaleDialog$LocaleComparator;->this$0:Lco/vine/android/LocaleDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lco/vine/android/LocaleDialog;Lco/vine/android/LocaleDialog$1;)V
    .locals 0
    .param p1, "x0"    # Lco/vine/android/LocaleDialog;
    .param p2, "x1"    # Lco/vine/android/LocaleDialog$1;

    .prologue
    .line 188
    invoke-direct {p0, p1}, Lco/vine/android/LocaleDialog$LocaleComparator;-><init>(Lco/vine/android/LocaleDialog;)V

    return-void
.end method


# virtual methods
.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 188
    check-cast p1, Ljava/util/Locale;

    .end local p1    # "x0":Ljava/lang/Object;
    check-cast p2, Ljava/util/Locale;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lco/vine/android/LocaleDialog$LocaleComparator;->compare(Ljava/util/Locale;Ljava/util/Locale;)I

    move-result v0

    return v0
.end method

.method public compare(Ljava/util/Locale;Ljava/util/Locale;)I
    .locals 4
    .param p1, "l1"    # Ljava/util/Locale;
    .param p2, "l2"    # Ljava/util/Locale;

    .prologue
    .line 191
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "-"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 192
    .local v0, "s1":Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p2}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "-"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p2}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 194
    .local v1, "s2":Ljava/lang/String;
    invoke-virtual {v0, v1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v2

    return v2
.end method

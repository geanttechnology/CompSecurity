.class final Lcom/wishabi/flipp/app/er;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/preference/Preference$OnPreferenceClickListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/eq;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/eq;)V
    .locals 0

    .prologue
    .line 64
    iput-object p1, p0, Lcom/wishabi/flipp/app/er;->a:Lcom/wishabi/flipp/app/eq;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onPreferenceClick(Landroid/preference/Preference;)Z
    .locals 3

    .prologue
    .line 67
    iget-object v0, p0, Lcom/wishabi/flipp/app/er;->a:Lcom/wishabi/flipp/app/eq;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/eq;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-static {v0}, Lcom/wishabi/flipp/content/aj;->a(Landroid/content/Context;)V

    .line 68
    iget-object v0, p0, Lcom/wishabi/flipp/app/er;->a:Lcom/wishabi/flipp/app/eq;

    iget-object v1, p0, Lcom/wishabi/flipp/app/er;->a:Lcom/wishabi/flipp/app/eq;

    const v2, 0x7f0e002b

    invoke-virtual {v1, v2}, Lcom/wishabi/flipp/app/eq;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/wishabi/flipp/app/eq;->a(Lcom/wishabi/flipp/app/eq;Ljava/lang/String;)V

    .line 69
    const/4 v0, 0x1

    return v0
.end method
